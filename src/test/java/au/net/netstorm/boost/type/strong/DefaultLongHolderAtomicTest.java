package au.net.netstorm.boost.type.strong;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultLongHolderAtomicTest extends BoooostCase {
    private final AtomTestChecker checker = new DataAtomTestChecker();
    private final FieldSpec property = new DefaultFieldSpec("value", long.class);
    private final FieldSpec[] fields = {property};

    public void testAtom() {
        checker.checkAtom(DefaultLongHolder.class, fields);
    }
}