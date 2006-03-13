package au.net.netstorm.boost.primordial;

import junit.framework.TestCase;

// FIXME: SC509 Add a test to make sure all of our tests inherit from this class.

// Would prefer not to declare this "abstract", but contract with JUnit/TestCase precludes this.

// FIXME: SC523 Move to test.primordial.
public abstract class PrimordialTestCase extends TestCase {
    private final AssertTestChecker asserter = new DefaultAssertTestChecker();

    public final void assertEquals(Object[] expected, Object[] fields) {
        asserter.checkEquals(expected, fields);
    }

    public final void testSoThePoxyScabJUnitDoesNotWhinge() {
    }
}
