package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Implementation;

public final class DefaultBlueprintAtomicTest extends InteractionTestCase {
    AtomTestChecker checker = new DataAtomTestChecker(random);
    FieldSpec f1 = new DefaultFieldSpec("stamp", Stamp.class);
    FieldSpec f2 = new DefaultFieldSpec("implementation", Implementation.class);
    FieldSpec f3 = new DefaultFieldSpec("flavour", Flavour.class);
    FieldSpec[] fields = {f1, f2, f3};

    public void testAtom() {
        checker.checkAtom(DefaultBlueprint.class, fields);
    }
}
