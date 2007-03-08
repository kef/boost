package au.net.netstorm.boost.nursery.reflect.checker;

import junit.framework.Assert;

public final class DefaultAssertTestChecker implements AssertTestChecker {

    // SUGGEST Refactor duplication, if possible.
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

    public void checkEquals(int[] expected, int[] actual) {
        Assert.assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) Assert.assertEquals(expected[i], actual[i]);
    }

    public void checkNotEquals(byte[] value1, byte[] value2) {
        if (value1.length != value2.length) return;
        for (int i = 0; i < value1.length; i++)
            if (value1[i] != value2[i]) return;
        Assert.fail();
    }

    public void checkImmutable(byte[] value1, byte[] value2) {
        Assert.assertTrue(value1 != value2);
        Assert.assertEquals(value1, value2);
    }
}
