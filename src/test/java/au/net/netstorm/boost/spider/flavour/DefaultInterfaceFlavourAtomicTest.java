package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultInterfaceFlavourAtomicTest extends BoooostCase {
    private final FieldSpec f1 = new DefaultFieldSpec("iface", Interface.class);
    private final FieldSpec f2 = new DefaultFieldSpec("flavour", Flavour.class);
    private final FieldSpec[] fields = {f1, f2};
    private final AtomTestChecker data = new DataAtomTestChecker();

    public void testAtom() {
        data.checkAtom(DefaultInterfaceFlavour.class, fields);
    }
}