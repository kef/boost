package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.gunge.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.sniper.atom.AtomTestChecker;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class DefaultLayerSpecAtomicTest extends LifecycleTestCase implements InjectableTest {
    FieldSpec f1 = new DefaultFieldSpec("layers", Class[].class);
    FieldSpec[] fields = {f1};
    AtomTestChecker checker;

    public void testData() {
        checker.checkAtom(DefaultLayerSpec.class, fields);
    }
}