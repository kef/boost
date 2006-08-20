package au.net.netstorm.boost.nursery.automock;

import au.net.netstorm.boost.nursery.reflect.checker.AssertTestChecker;
import au.net.netstorm.boost.nursery.reflect.checker.DefaultAssertTestChecker;
import junit.framework.TestCase;

// SUGGEST Remove the need for this altogether.
// Would prefer not to declare this "abstract", but contract with JUnit/TestCase precludes this.
public abstract class PrimordialTestCase extends TestCase {
    private final AssertTestChecker asserter = new DefaultAssertTestChecker();

    public final void assertEquals(Object[] expected, Object[] fields) {
        asserter.checkEquals(expected, fields);
    }
}
