package au.net.netstorm.boost.primordial;

import junit.framework.Assert;

// FIXME: ? SC506 Instancise.
// Do not extend Assert.  Users of this class may inadvertently pick up Assert's methods.  We don't want this :)
public class AssertTestUtil  {

    public static final void checkEquals(Object[] expected, Object[] actual) {
        Assert.assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) Assert.assertEquals(""+i, expected[i], actual[i]);
    }

    public static final void checkEquals(byte[] expected, byte[] actual) {
        Assert.assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) Assert.assertEquals(""+i, expected[i], actual[i]);
    }
}
