package au.net.netstorm.boost.test.reflect.util;

import java.lang.reflect.InvocationTargetException;

// FIX SC050 What a pile of smelly rot.

public final class DefaultExceptionTestUtil implements ExceptionTestUtil {
    public Class getRealExceptionClass(Throwable t) {
        // FIX SC050 This certainly does not really work.  Sort this out!!!
        Throwable realException = t;
        if (realException.getClass() == RuntimeException.class) realException = realException.getCause();
        if (realException.getClass() == InvocationTargetException.class)
            realException = realException.getCause(); // FIX SC050 Bloody amateurs.  This should be getTargetInvocation ...
        return realException.getClass();
    }

    // FIX SC524 Build up Boost version of this.
//    private static final String MESSAGE_1 = "message 1";
//    private static final String MESSAGE_2 = "message 2";
//
//    public static void checkException(Class cls) {
//        ClassPropertiesTestUtil.checkSubclassOf(RuntimeException.class, cls);
//        ClassPropertiesTestUtil.checkClassFinal(cls);
//        checkException(cls, MESSAGE_1);
//        checkException(cls, MESSAGE_2);
//    }
//
//    public static void checkExceptionWrapping(Throwable expectedWrapped, String expectedMessage, Throwable actualWrapper) {
//        checkExceptionWrapping(expectedWrapped, actualWrapper);
//        checkMessage(expectedMessage, actualWrapper);
//    }
//
//    public static void checkExceptionWrapping(Throwable expectedWrapped, Throwable actualWrapper) {
//        Assert.assertEquals(expectedWrapped, actualWrapper.getCause());
//    }
//
//    private static void checkMessage(String expectedMessage, Throwable actualWrapper) {
//        Assert.assertEquals("Incorrect message", expectedMessage, actualWrapper.getMessage());
//    }
//
//    private static void checkException(Class cls, String message) {
//        RuntimeException e = createException(cls, message);
//        Assert.assertEquals(message, e.getMessage());
//    }
//
//    private static RuntimeException createException(Class cls, String message) {
//        try {
//            Constructor constructor = cls.getConstructor(new Class[] {String.class});
//            return (RuntimeException) constructor.newInstance(new Object[] {message});
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
