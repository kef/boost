package au.net.netstorm.boost.demo.data;

import junit.framework.TestCase;
import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.LooseDataAtomTestChecker;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;

public final class LooseDataAtomDemoTest extends TestCase {
    private static final FieldSpec STRING_PROPERTY = new DefaultFieldSpec("guitar", String.class);
    private static final FieldSpec[] SINGLE_STRING_PROPERTY = { STRING_PROPERTY };

    private AtomTestChecker checker = new LooseDataAtomTestChecker();

    public void testGoodAtoms() {
        checkGoodAtom(NullsAreIllegalData.class, SINGLE_STRING_PROPERTY);
    }

    private void checkGoodAtom(Class cls, FieldSpec[] fields) {
        checker.checkAtom(cls, fields);
    }
}