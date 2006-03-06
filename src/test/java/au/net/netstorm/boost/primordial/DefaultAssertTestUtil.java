package au.net.netstorm.boost.primordial;

import junit.framework.Assert;

// FIXME: ? SC506 Instancise.
// FIXME: SC521 Interface.
// Do not extend Assert.  Users of this class may inadvertently pick up Assert's methods.  We don't want this :)
// FIXME: SC521 This is an AssertTestChecker.

public final class DefaultAssertTestUtil implements AssertTestUtil {
    public void checkEquals(Object[] expected, Object[] actual) {
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) Assert.assertEquals("" + i, expected[i], actual[i]);
    }

    public void checkEquals(byte[] expected, byte[] actual) {
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) Assert.assertEquals("" + i, expected[i], actual[i]);
    }
}
