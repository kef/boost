package au.net.netstorm.boost.retire.reflect;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.Assert;

public final class DefaultAssertException implements AssertException {

    public Throwable assertWraps(Class expectedException, Throwable wrapperException) {
        return assertWraps(expectedException, wrapperException, 1);
    }

    public Throwable assertWraps(Class expectedException, String expectedMessage, Throwable wrapperException) {
        return assertWraps(expectedException, expectedMessage, wrapperException, 1);
    }

    public Throwable assertWraps(Class expectedExceptionClass, Throwable wrapperException, int depthExceptionShouldAppearAt) {
        int realDepth = depthExceptionShouldAppearAt <= 0 ? Integer.MAX_VALUE : depthExceptionShouldAppearAt;
        return checkWraps(expectedExceptionClass, wrapperException, realDepth);
    }

    public Throwable assertWraps(Class expectedExceptionClass, String expectedMessage, Throwable wrapperException, int depthExceptionShouldAppearAt) {
        Throwable cause = assertWraps(expectedExceptionClass, wrapperException, depthExceptionShouldAppearAt);
        checkExceptionMessage(expectedMessage, cause);
        return cause;
    }

    public void checkExceptionClass(Class expectedExceptionClass, Throwable actual) {
        // SUGGEST Use something else.  Delegate.
        // SUGGEST How about a stacktrace object?
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        actual.printStackTrace(new PrintStream(out));
        Class cls = actual.getClass();
        String message = "Expected " + expectedExceptionClass + " but was " + cls + ", stack trace:\n";
        Assert.assertEquals(message + out, expectedExceptionClass, cls);
    }

    public void checkExceptionMessage(String expectedMessage, Throwable actual) {
        Assert.assertEquals("Exception message doesn't match", expectedMessage, actual.getMessage());
    }

    // SUGGEST Refactor this.
    private Throwable checkWraps(Class expectedExceptionClass, Throwable wrapperException, int depth) {
        Throwable cause = getCauseAtDepth(wrapperException, depth);
        checkExceptionClass(expectedExceptionClass, cause);
        return cause;
    }

    // SUGGEST Too big.

    // DEBT JavaNCSS {

    private Throwable getCauseAtDepth(Throwable wrapperException, int depth) {
        Throwable cause = wrapperException.getCause();
        boolean maxedOut = cause == wrapperException;
        int currentDepth = 1;
        while (!maxedOut && currentDepth < depth) {
            Throwable currentWrapper = cause;
            cause = cause.getCause();
            maxedOut = cause == currentWrapper;
            currentDepth++;
        }
        if (depth != Integer.MAX_VALUE) {
            Assert.assertEquals("Wrapped exception not found at correct depth ", depth, currentDepth);
        }
        return cause;
    }
// } DEBT JavaNCSS
}
