package au.net.netstorm.boost.nursery.reflect.checker;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

public final class DefaultAssertThrows implements AssertThrows {
    private AssertException assertException = new DefaultAssertException();

    // SUGGEST AssertThrowsChecker.
    // SUGGEST Why is the caught exception returned. (TJA: For additional checking not supplied by this class. Smelly.)
    public Throwable assertThrows(Class expectedException, String message, Block block) {
        Throwable result = assertThrows(expectedException, block);
        assertException.checkExceptionMessage(message, result);
        return result;
    }

    public Throwable assertThrows(Class expectedException, Block block) {
        Throwable result = null;
        try {
            block.execute();
            Assert.fail("Failed to throw exception: " + expectedException);
        } catch (AssertionFailedError e) {
            throw e;
        } catch (Throwable t) {
            assertException.checkExceptionClass(expectedException, t);
            result = t;
        }
        return result;
    }

    public void assertMessageContains(Throwable t, String fragment) {
        String message = "Fragment '" + fragment + "' not found in message '" + t.getMessage() + "' ";
        Assert.assertTrue(message, t.getMessage().indexOf(fragment) > -1);
    }
}