package au.net.netstorm.boost.test.checker;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.util.instance.InstanceProvider;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import junit.framework.Assert;

public final class DefaultConstructorNullParameterTestChecker implements ConstructorNullParameterTestChecker {
    private static final DefaultNullMaster NULL_MASTER = new DefaultNullMaster();
    private static final DefaultAssertException ASSERT_EXCEPTION = new DefaultAssertException();
    private final InstanceProvider instanceProvider;
    private static final DefaultClassMaster CLASS_MASTER = new DefaultClassMaster();

    public DefaultConstructorNullParameterTestChecker(InstanceProvider instanceProvider) {
        NULL_MASTER.check(instanceProvider, "instanceProvider");
        this.instanceProvider = instanceProvider;
    }

    public void checkPublicConstructorsRejectNull(Class classToCheck) {
        NULL_MASTER.check(classToCheck, "classToCheck");
        Constructor[] constructors = classToCheck.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            checkConstructorRejectsNull(constructors[i]);
        }
    }

    public void checkConstructorRejectsNull(Constructor constructor) {
        NULL_MASTER.check(constructor, "constructor");
        Class[] paramTypes = constructor.getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            nullCheckConstructor(constructor, i, paramTypes);
        }
    }

    private void nullCheckConstructor(Constructor constructor, int currentParameter, Class[] paramTypes) {
        Object[] paramValues = createParametersWithNull(currentParameter, paramTypes);
        try {
            invokeConstructor(constructor, paramValues);
            String className = CLASS_MASTER.getShortName(paramTypes[currentParameter]);
            String message = "Argument number " + (currentParameter + 1) + " (of type " + className + ") must be null checked";
            Assert.fail(message);
        } catch (Exception e) {
            checkExceptionIsIllegalArgumentException(e);
        }
    }

    // FIXME TJA: Also check message here once null checks are consistent.
    private void checkExceptionIsIllegalArgumentException(Exception e) {
        ASSERT_EXCEPTION.checkExceptionClass(IllegalArgumentException.class, e);
    }

    private Object[] createParametersWithNull(int paramToMakeNull, Class[] paramTypes) {
        Object[] paramValues = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            paramValues[i] = instanceProvider.newInstance(paramTypes[i]);
        }
        paramValues[paramToMakeNull] = null;
        return paramValues;
    }

    private void invokeConstructor(Constructor constructor, Object[] paramValues) {
        try {
            constructor.setAccessible(true);
            EdgeConstructor.EDGE_CONSTRUCTOR
                    .newInstance(constructor, paramValues);
        } catch (EdgeException e) {
            Throwable cause = e.getCause();
            if (cause instanceof InvocationTargetException) {
                throw (IllegalArgumentException) cause.getCause();
            }
        }
    }
}
