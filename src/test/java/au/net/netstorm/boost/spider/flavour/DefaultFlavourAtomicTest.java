package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultFlavourAtomicTest extends BoooostCase {
    private final FieldSpec property = new DefaultFieldSpec("value", String.class);
    private final FieldSpec[] fields = {property};
    private final AtomTestChecker checker = new DataAtomTestChecker();

    public void testAtom() {
        checker.checkAtom(DefaultFlavour.class, fields);
    }
}