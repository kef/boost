package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.gunge.atom.AtomTestChecker;
import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.InjectableTest;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultLayerSpecAtomicTest extends LifecycleTestCase implements InjectableTest {
    FieldSpec f1 = new DefaultFieldSpec("layers", Class[].class);
    FieldSpec[] fields = {f1};
    AtomTestChecker checker;

    public void testData() {
        checker.checkAtom(DefaultLayerSpec.class, fields);
    }
}