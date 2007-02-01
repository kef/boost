package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.nursery.reflect.checker.AssertTestChecker;
import au.net.netstorm.boost.nursery.reflect.checker.DefaultAssertTestChecker;
import junit.framework.TestCase;

// SUGGEST Remove the need for this altogether.
// FIX SC600 BREADCRUMB Complete.
// FIX SC600 Check bottom level classes are final.
// FIX SC600 Check no-arg (single) constructor.
// FIX SC600 Redefine setUp() to setup() which does not throw an exception.
public abstract class AssertTestCase extends TestCase {
    private final AssertTestChecker asserter = new DefaultAssertTestChecker();

    public final void assertEquals(Object[] expected, Object[] fields) {
        asserter.checkEquals(expected, fields);
    }
}
