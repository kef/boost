package au.net.netstorm.boost.primordial;

import junit.framework.Assert;

// FIXME: ? SC506 Instancise.
public class AssertTestUtil extends Assert {
    
    public static final void checkEquals(Object[] expected, Object[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) assertEquals(""+i, expected[i], actual[i]);
    }
}
