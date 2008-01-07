package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultFlavourAtomicTest extends LifecycleTestCase implements InjectableTest {
    FieldSpec property = new DefaultFieldSpec("value", String.class);
    FieldSpec[] fields = {property};
    AtomTestChecker checker;

    public void testAtom() {
        checker.checkAtom(DefaultFlavour.class, fields);
    }
}