package au.net.netstorm.boost.nursery.reflect.checker;

import junit.framework.Assert;

// Do not extend Assert.  Users of this class may inadvertently pick up Assert's methods.  We don't want this :)
public final class DefaultAssertTestChecker implements AssertTestChecker {
    // FIX SC524 Refactor duplication, if possible.
    public void checkEquals(Object[] expected, Object[] actual) {
        Assert.assertNotNull(expected);
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) Assert.assertEquals("" + i, expected[i], actual[i]);
    }

    public void checkEquals(byte[] expectedBytes, byte[] actualBytes) {
        Assert.assertNotNull(expectedBytes);
        Assert.assertNotNull(actualBytes);
        Assert.assertEquals(expectedBytes.length, actualBytes.length);
        for (int i = 0; i < actualBytes.length; i++) Assert.assertEquals("" + i, expectedBytes[i], actualBytes[i]);
    }
}
