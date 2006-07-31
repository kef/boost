package au.net.netstorm.boost.test.checker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.test.reflect.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.ModifierTestUtil;
import au.net.netstorm.boost.util.instance.InstanceProvider;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import au.net.netstorm.boost.util.nullo.NullMaster;
import junit.framework.Assert;

public final class DefaultMethodNullParameterTestChecker implements MethodNullParameterTestChecker {
    private static final NullMaster NULL_MASTER = new DefaultNullMaster();
    private static final ModifierTestUtil MODIFIER_UTIL = new DefaultModifierTestUtil();
    private static final AssertException ASSERT_EXCEPTION = new DefaultAssertException();
    private final EdgeMethod edgeMethod = new DefaultEdgeMethod();
    private final ParameterTestUtil parameterUtil = new DefaultParameterTestUtil();
    private final InstanceProvider instanceProvider;

    public DefaultMethodNullParameterTestChecker(InstanceProvider instanceProvider) {
        NULL_MASTER.check(instanceProvider, "instanceProvider");
        this.instanceProvider = instanceProvider;
    }

    public void checkPublicMethodsRejectNull(Object instance) {
        NULL_MASTER.check(instance);
        Method[] methods = getPublicMethods(instance.getClass());
        for (int i = 0; i < methods.length; i++) {
            checkMethodRejectsNull(instance, methods[i]);
        }
    }

    private void checkMethodRejectsNull(Object instance, Method method) {
        NULL_MASTER.check(method);
        Class[] paramTypes = method.getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            nullCheckMethod(instance, method, i, paramTypes);
        }
    }

    // FIXME: SC523 Pass block, reduce duplication with constructor form.
    private void nullCheckMethod(Object instance, final Method method, int currentParameter, Class[] paramTypes) {
        final Object[] paramValues = parameterUtil.createParameterValuesWithNull(instanceProvider, paramTypes, currentParameter);
        try {
            invoke(instance, method, paramValues);
            fail(paramTypes, currentParameter, method);
        } catch (Exception e) {
            ASSERT_EXCEPTION.checkExceptionClass(IllegalArgumentException.class, e);
        }
    }

    // FIXME: SC043 R Why do we need the Call block?
    // FIXME: SC043 This method is DUP with ConstructorNullParameter.
    private void invoke(final Object instance, final Method method, final Object[] paramValues) {
        method.setAccessible(true);
        Call invokeBlock = new Call() {
            public void execute() {
                edgeMethod.invoke(method, instance, paramValues);
            }
        };
        parameterUtil.invokeBlock(invokeBlock);
    }

    private void fail(Class[] paramTypes, int currentParameter, Method method) {
        String paramTypeClassName = paramTypes[currentParameter].getSimpleName();
        // FIXME: SC043 Trainwreck.
        String instanceClassName = method.getDeclaringClass()
                .getSimpleName();
        String methodName = instanceClassName + "." + method.getName();
        String message = "Argument " + (currentParameter + 1) + " of " + methodName + "(..." + paramTypeClassName + "...) must be null checked";
        Assert.fail(message);
    }

    // FIXME: SC523 Better way to do this, maybe boost class?
    private Method[] getPublicMethods(Class cls) {
        List publicMethods = new ArrayList();
        Method[] methods = cls.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (MODIFIER_UTIL.isPublic(methods[i])) {
                publicMethods.add(methods[i]);
            }
        }
        return (Method[]) publicMethods.toArray(new Method[]{});
    }
}
