package au.net.netstorm.boost.demo.pebble;

import junit.framework.TestCase;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.util.introspect.FieldSpec;

// FIX 1665 Complete.
public final class DefaultImplementationAtomicTest extends TestCase {
    private AtomTestChecker checker = new DataAtomTestChecker();
    private FieldSpec[] fields = { };

    public void testDataAtom() {
        checker.checkAtom(DefaultImplementation.class, fields);
    }
}
