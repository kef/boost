package au.net.netstorm.boost.primordial;

import junit.framework.Assert;

// FIXME: ? SC506 Instancise.
public class AssertTestUtil extends Assert {
    public static final void assertEquals(Object[] expected, Object[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) assertEquals(expected[i], actual[i]);
    }
}
