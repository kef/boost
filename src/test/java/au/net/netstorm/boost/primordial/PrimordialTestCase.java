package au.net.netstorm.boost.primordial;

import junit.framework.TestCase;

// FIXME: SC524 Remove the need for this altogether.
// Would prefer not to declare this "abstract", but contract with JUnit/TestCase precludes this.
public abstract class PrimordialTestCase extends TestCase {
    private final AssertTestChecker asserter = new DefaultAssertTestChecker();

    public final void assertEquals(Object[] expected, Object[] fields) {
        asserter.checkEquals(expected, fields);
    }

    public final void testSoThePoxyScabJUnitDoesNotWhinge() {
    }
}
