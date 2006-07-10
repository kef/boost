package au.net.netstorm.boost.test.checker;

import junit.framework.Assert;

public final class DefaultAssertException implements AssertException {
    public Throwable assertWraps(Throwable wrapperException, Class expectedException) {
        return assertWraps(wrapperException, expectedException, 1);
    }

    public Throwable assertWraps(Throwable wrapperException, Class expectedException, String message) {
        return assertWraps(wrapperException, message, expectedException, 1);
    }

    public Throwable assertWraps(Throwable wrapperException, Class exceptionClass, int depthExceptionShouldAppearAt) {
        int realDepth = depthExceptionShouldAppearAt <= 0 ? Integer.MAX_VALUE : depthExceptionShouldAppearAt;
        return checkWraps(wrapperException, exceptionClass, realDepth);
    }

    public Throwable assertWraps(Throwable wrapperException, String message, Class exceptionClass, int depthExceptionShouldAppearAt) {
        Throwable cause = assertWraps(wrapperException, exceptionClass, depthExceptionShouldAppearAt);
        checkExceptionMessage(message, cause);
        return cause;
    }

    public void checkExceptionClass(Class exceptionClass, Throwable throwable) {
        Assert.assertEquals(exceptionClass, throwable.getClass());
    }

    public void checkExceptionMessage(String expectedMessage, Throwable throwable) {
        Assert.assertEquals("Exception message doesn't match", expectedMessage, throwable.getMessage());
    }

    private Throwable checkWraps(Throwable wrapperException, Class exceptionClass, int depth) {
        Throwable cause = wrapperException.getCause();
        boolean maxedOut = cause == wrapperException;
        int currentDepth = 1;
        while (!maxedOut && currentDepth < depth) {
            Throwable currentWrapper = cause;
            cause = cause.getCause();
            maxedOut = cause == currentWrapper;
            currentDepth ++;
        }
        if (depth != Integer.MAX_VALUE) {
            Assert.assertEquals("Wrapped exception not found at correct depth ", depth, currentDepth);
        }
        checkExceptionClass(exceptionClass, cause);
        return cause;
    }
}
