package au.net.netstorm.boost.nursery.reflect.checker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.nursery.instance.InstanceProvider;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import au.net.netstorm.boost.util.nullo.NullMaster;
import junit.framework.Assert;

// DEBT ClassDataAbstractionCoupling {
public final class DefaultMethodNullParameterTestChecker implements MethodNullParameterTestChecker {
    private final NullMaster nullMaster = new DefaultNullMaster();
    private final ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();
    private final AssertException assertException = new DefaultAssertException();
    private final EdgeMethod edgeMethod = new DefaultEdgeMethod();
    private final ParameterTestUtil parameterUtil = new DefaultParameterTestUtil();
    private final InstanceProvider instanceProvider;

    public DefaultMethodNullParameterTestChecker(InstanceProvider instanceProvider) {
        nullMaster.check(instanceProvider, "instanceProvider");
        this.instanceProvider = instanceProvider;
    }

    public void checkPublicMethodsRejectNull(Object instance) {
        nullMaster.check(instance);
        Method[] methods = getPublicMethods(instance.getClass());
        for (int i = 0; i < methods.length; i++) {
            checkMethodRejectsNull(instance, methods[i]);
        }
    }

    private void checkMethodRejectsNull(Object instance, Method method) {
        Class[] paramTypes = method.getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            nullCheckMethod(instance, method, i, paramTypes);
        }
    }

    // SUGGEST Pass block, reduce duplication with constructor form.
    private void nullCheckMethod(Object instance, final Method method, int currentParameter, Class[] paramTypes) {
        final Object[] paramValues = parameterUtil.createBadParamValues(instanceProvider, paramTypes, currentParameter, null);
        try {
            invoke(instance, method, paramValues);
            fail(paramTypes, currentParameter, method);
        } catch (Exception e) {
            assertException.checkExceptionClass(IllegalArgumentException.class, e);
        }
    }

    // SUGGEST This method is DUP with ConstructorNullParameter.
    private void invoke(final Object instance, final Method method, final Object[] paramValues) {
        method.setAccessible(true);
        try {
            edgeMethod.invoke(method, instance, paramValues);
        } catch (EdgeException e) {
            parameterUtil.handleException(e);
        }
    }

    private void fail(Class[] paramTypes, int currentParameter, Method method) {
        String paramTypeClassName = paramTypes[currentParameter].getSimpleName();
        Class declaringClass = method.getDeclaringClass();
        String instanceClassName = declaringClass.getSimpleName();
        String methodName = instanceClassName + "." + method.getName();
        String message = "Argument " + (currentParameter + 1) + " of " + methodName + "(..." + paramTypeClassName + "...) must be null checked";
        Assert.fail(message);
    }

    // SUGGEST Better way to do this?
    private Method[] getPublicMethods(Class cls) {
        List publicMethods = new ArrayList();
        Method[] methods = cls.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (modifierUtil.isPublic(methods[i])) {
                publicMethods.add(methods[i]);
            }
        }
        return (Method[]) publicMethods.toArray(new Method[]{});
    }
}
// } DEBT ClassDataAbstractionCoupling
