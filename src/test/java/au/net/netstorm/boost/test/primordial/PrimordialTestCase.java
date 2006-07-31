package au.net.netstorm.boost.test.primordial;

import au.net.netstorm.boost.test.checker.AssertTestChecker;
import au.net.netstorm.boost.test.checker.DefaultAssertTestChecker;
import junit.framework.TestCase;

// FIX SC524 Remove the need for this altogether.
// Would prefer not to declare this "abstract", but contract with JUnit/TestCase precludes this.
public abstract class PrimordialTestCase extends TestCase {
    private final AssertTestChecker asserter = new DefaultAssertTestChecker();

    public final void assertEquals(Object[] expected, Object[] fields) {
        asserter.checkEquals(expected, fields);
    }
}
