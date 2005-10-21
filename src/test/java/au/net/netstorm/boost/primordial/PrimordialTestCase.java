package au.net.netstorm.boost.primordial;

import junit.framework.TestCase;

// FIXME: SC501 Add a test to make sure all of our tests inherit from this class.
// FIXME: SC501 Should this be in "edge".  Probably.

// Would prefer not to declare this "abstract", but contract with JUnit/TestCase precludes this.
public abstract class PrimordialTestCase extends TestCase {
    public final void assertEquals(Object[] expected, Object[] fields) {
        AssertTestUtil.assertEquals(expected, fields);
    }

    public final void testSoThePoxyScabJUnitDoesNotWhinge() {
    }
}
