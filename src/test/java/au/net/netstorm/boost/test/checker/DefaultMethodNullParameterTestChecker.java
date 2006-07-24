package au.net.netstorm.boost.test.checker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import au.net.netstorm.boost.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.test.reflect.DefaultModifierTestUtil;
import au.net.netstorm.boost.util.instance.InstanceProvider;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import junit.framework.Assert;

public final class DefaultMethodNullParameterTestChecker implements MethodNullParameterTestChecker {
    private static final DefaultNullMaster NULL_MASTER = new DefaultNullMaster();
    private static final DefaultClassMaster CLASS_MASTER = new DefaultClassMaster();
    private static final DefaultModifierTestUtil MODIFIER_UTIL = new DefaultModifierTestUtil();
    private final InstanceProvider instanceProvider;

    public DefaultMethodNullParameterTestChecker(InstanceProvider instanceProvider) {
        NULL_MASTER.check(instanceProvider, "instanceProvider");
        this.instanceProvider = instanceProvider;
    }

    public void checkPublicMethodsRejectNull(Class classToCheck) {
        NULL_MASTER.check(classToCheck, "classToCheck");
        List methods = getPublicMethods(classToCheck);
        for (Iterator iterator = methods.iterator(); iterator.hasNext();) {
            checkMethodRejectsNull((Method) iterator.next());
        }
    }

    public void checkMethodRejectsNull(Method method) {
        NULL_MASTER.check(method, "method");
        Class[] paramTypes = method.getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            nullCheckMethod(method, i, paramTypes);
        }
    }

    // FIXME: SC523 Pass block, reduce duplication with constructor form.
    private void nullCheckMethod(final Method method, int currentParameter, Class[] paramTypes) {
        final Object[] paramValues = ParameterTestUtil.createParameterValuesWithNull(instanceProvider, paramTypes, currentParameter);
        try {
            invoke(method, paramValues);
            fail(paramTypes, currentParameter, method);
        } catch (Exception e) {
            ParameterTestUtil.checkExceptionIsIllegalArgumentException(e);
        }
    }

    private void invoke(final Method method, final Object[] paramValues) {
        final Object instance = instanceProvider.newInstance(method.getDeclaringClass());
        method.setAccessible(true);
        Call invokeBlock = new Call() {
            public void execute() {
                EdgeMethod.EDGE_METHOD.invoke(method, instance, paramValues);
            }
        };
        ParameterTestUtil.invokeBlock(invokeBlock);
    }

    private void fail(Class[] paramTypes, int currentParameter, Method method) {
        String paramTypeClassName = CLASS_MASTER.getShortName(paramTypes[currentParameter]);
        String instanceClassName = CLASS_MASTER.getShortName(method.getDeclaringClass());
        String methodName = instanceClassName + "." + method.getName();
        String message = "Argument " + (currentParameter + 1) + " of " + methodName + "(..." + paramTypeClassName + "...) must be null checked";
        Assert.fail(message);
    }

    // FIXME: SC523 Better way to do this, maybe boost class?
    private List getPublicMethods(Class cls) {
        List publicMethods = new ArrayList();
        Method[] methods = cls.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (MODIFIER_UTIL.isPublic(methods[i])) {
                publicMethods.add(methods[i]);
            }
        }
        return publicMethods;
    }
}
