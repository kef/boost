package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.gunge.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.sniper.atom.AtomTestChecker;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public class DefaultEdgeTypeAtomicTest extends LifecycleTestCase implements InjectableTest {
    AtomTestChecker atom;
    FieldSpec f1 = new DefaultFieldSpec("edge", Class.class);
    FieldSpec f2 = new DefaultFieldSpec("real", Class.class);
    FieldSpec[] fields = {f1, f2};

    public void testData() {
        atom.checkAtom(DefaultEdgeType.class, fields);
    }
}
