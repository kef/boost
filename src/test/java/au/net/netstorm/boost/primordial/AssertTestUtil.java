package au.net.netstorm.boost.primordial;

import junit.framework.Assert;

// FIXME: ? SC506 Instancise.
class AssertTestUtil extends Assert {
    public static final void assertEquals(Object[] expected, Object[] fields) {
        assertEquals(expected.length, fields.length);
        for (int i = 0; i < fields.length; i++) assertEquals(expected[i], fields[i]);
    }
}
