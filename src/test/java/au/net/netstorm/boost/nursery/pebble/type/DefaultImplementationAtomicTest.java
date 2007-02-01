package au.net.netstorm.boost.nursery.pebble.type;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public final class DefaultImplementationAtomicTest extends TestCase  {
    private AtomTestChecker checker = new DataAtomTestChecker();
    private FieldSpec f1 = new DefaultFieldSpec("types", Interface[].class);
    private FieldSpec f2 = new DefaultFieldSpec("impl", Class.class);
    private FieldSpec[] fields = { f1, f2};

    public void testDataAtom() {
        checker.checkAtom(DefaultImplementation.class, fields);
    }
}
