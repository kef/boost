package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Implementation;

// FIX 2081 Use or lose.
public final class DefaultBlueprintAtomicTest extends InteractionTestCase {
    AtomTestChecker checker = new DataAtomTestChecker(random);
    FieldSpec f1 = new DefaultFieldSpec("stamp", Stamp.class);
    FieldSpec f2 = new DefaultFieldSpec("implementation", Implementation.class);
    FieldSpec[] fields = {f1, f2};

    public void testXxx() {
        checker.checkAtom(DefaultBlueprint.class, fields);
    }
}
