package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultFlavourAtomicTest extends InteractionTestCase {
    FieldSpec property = new DefaultFieldSpec("value", String.class);
    FieldSpec[] fields = {property};
    AtomTestChecker checker = new DataAtomTestChecker(specifics);

    public void testAtom() {
        checker.checkAtom(DefaultFlavour.class, fields);
    }
}