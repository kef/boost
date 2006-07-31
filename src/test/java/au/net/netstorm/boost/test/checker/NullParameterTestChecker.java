package au.net.netstorm.boost.test.checker;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.test.fixture.TriangulationProvider;

// FIX SC524 Build up Boost version of this.
// FIX SC523 Pull in latest external changes.
// FIX SC524 Make an interface for this.
public final class NullParameterTestChecker {
//    private static final InstanceProviderTestUtil INSTANCE_PROVIDER_TEST_UTIL = new InstanceProviderTestUtil();
//    private static final ExceptionTestUtil EXCEPTION_TEST_UTIL = new DefaultExceptionTestUtil();

    // FIX SC050 Given we're seeing a lot of the constructor/parameters together, isn't it about time to build an aggregate?
    // FIX SC523 Rename additional.
    public void checkNullConstructorParameters(Constructor constructor, Class[] parameterTypes, TriangulationProvider additional) {
//        for (int i = 0; i < parameterTypes.length; i++) {
//            if (!parameterTypes[i].isPrimitive()) {
//                checkNullParameter(constructor, parameterTypes, i, additional);
//            }
//        }
    }

//    private void checkNullParameter(Constructor constructor, Class[] parameterTypes, int currentParameter, InstanceProvider additional) {
//        Object[] parameters = getParamsWithNull(parameterTypes, currentParameter, additional);
//        try {
//            INSTANCE_PROVIDER_TEST_UTIL.getInstance(constructor, parameters);
//            Class parameterType = parameterTypes[currentParameter];
//            String message = "NULLs are evil!!! This object allows null for argument number " + (currentParameter + 1) +
//                    " of type " + parameterType;
//            Assert.fail(message);
//        } catch (RuntimeException e) {
//            checkExpected(e);
//        }
//        ThrowAssert.assertThrows(IllegalArgumentException.class, cls, parameters, message);
//    }
//
//    private void checkExpected(RuntimeException e) {
//        if (!isExpected(e)) throw e;
//    }
//
//    private Object[] getParamsWithNull(Class[] parameterTypes, int currentParameter, InstanceProvider additional) {
//        Object[] parameters = INSTANCE_PROVIDER_TEST_UTIL.getInstances(parameterTypes, additional);
//        parameters[currentParameter] = null;
//        return parameters;
//    }
//
//    private boolean isExpected(RuntimeException e) {
//        Class cls = EXCEPTION_TEST_UTIL.getRealExceptionClass(e); // FIX SC050 Is this needed?
//        return isIllegalArgumentException(cls);
//    }
//
//    private boolean isIllegalArgumentException(Class cls) {
//        return cls.equals(IllegalArgumentException.class);
//    }
//}
//
//final class ThrowAssert {
//    public static void assertThrows(Class expectedException, Class implementation, Object[] parameterValues,
//                                      String assertionMessage) {
//        ExceptionResult result = tryCall(new ConstructionBlock(implementation, parameterValues), expectedException);
//        Assert.assertTrue(assertionMessage, result.getExceptionThrown());
//    }
//
//    private static ExceptionResult tryCall(Block block, Class throwable) {
//        try {
//            block.call();
//            return new ExceptionResult(false);
//        } catch (Throwable t) {
//            return correctExceptionThrown(throwable, t);
//        }
//    }
//
//    private static ExceptionResult correctExceptionThrown(Class throwable, Throwable t) {
//        checkException(throwable, t);
//        return new ExceptionResult(true);
//    }
//
//    private static void checkException(Class expectedType, Throwable t) {
//        if (!isExpectedException(expectedType, t)) {
//            fail(expectedType, t);
//        }
//    }
//
//    private static void fail(Class expectedType, Throwable t) {
//        AssertionFailedError error =
//                new AssertionFailedError("Expected exception of type '" + expectedType.getName() + "' but exception was " + t);
//        error.initCause(t);
//        throw error;
//    }
//
//    private static boolean isExpectedException(Class expectedType, Throwable t) {
//        return expectedType.isAssignableFrom(t.getClass());
//    }
//
//    private static final class ExceptionResult {
//        private final boolean exceptionThrown;
//
//        private ExceptionResult(boolean expectedThrowableThrown) {
//            this.exceptionThrown = expectedThrowableThrown;
//        }
//
//        private boolean getExceptionThrown() {
//            return exceptionThrown;
//        }
//    }
//}
//
//interface Block {
//    void call() throws Throwable;
//}
//
//class ConstructionBlock implements Block {
//    private final Class implementation;
//    private final Object[] instances;
//
//    public ConstructionBlock(Class implementation, Object[] instances) {
//        this.implementation = implementation;
//        this.instances = instances;
//    }
//
//    public void call() throws Throwable {
//        Constructor constructor = new ReflectConstructorUtil().getConstructor(implementation);
//        constructor.setAccessible(true);
//        try {
//            constructor.newInstance(instances);
//        } catch (InstantiationException e) {
//            throw e.getCause();
//        } catch (InvocationTargetException e) {
//            throw e.getCause();
//        }
//    }
}
