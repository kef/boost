package au.net.netstorm.boost.test.reflect.checker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.Assert;

public final class DefaultAssertException implements AssertException {
    public Throwable assertWraps(Throwable wrapperException, Class expectedException) {
        return assertWraps(wrapperException, expectedException, 1);
    }

    public Throwable assertWraps(Throwable wrapperException, Class expectedException, String expectedMessage) {
        return assertWraps(wrapperException, expectedMessage, expectedException, 1);
    }

    public Throwable assertWraps(Throwable wrapperException, Class expectedExceptionClass, int depthExceptionShouldAppearAt) {
        int realDepth = depthExceptionShouldAppearAt <= 0 ? Integer.MAX_VALUE : depthExceptionShouldAppearAt;
        return checkWraps(wrapperException, expectedExceptionClass, realDepth);
    }

    public Throwable assertWraps(Throwable wrapperException, String expectedMessage, Class expectedExceptionClass, int depthExceptionShouldAppearAt) {
        Throwable cause = assertWraps(wrapperException, expectedExceptionClass, depthExceptionShouldAppearAt);
        checkExceptionMessage(expectedMessage, cause);
        return cause;
    }

    public void checkExceptionClass(Class expectedExceptionClass, Throwable throwable) {
        // FIX SC600 Use something else.  Delegate.
        // FIX SC600 How about a stacktrace object?
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        throwable.printStackTrace(new PrintStream(out));
        Class cls = throwable.getClass();
        String message = "Expected " + expectedExceptionClass + " but was " + cls + ", stack trace:\n";
        Assert.assertEquals(message + out, expectedExceptionClass, cls);
    }

    public void checkExceptionMessage(String expectedMessage, Throwable throwable) {
        Assert.assertEquals("Exception message doesn't match", expectedMessage, throwable.getMessage());
    }

    // FIX SC523 Refactor this.
    private Throwable checkWraps(Throwable wrapperException, Class expectedExceptionClass, int depth) {
        Throwable cause = getCauseAtDepth(wrapperException, depth);
        checkExceptionClass(expectedExceptionClass, cause);
        return cause;
    }

    // FIX SC043 Too big.
    private Throwable getCauseAtDepth(Throwable wrapperException, int depth) {
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
        return cause;
    }
}
