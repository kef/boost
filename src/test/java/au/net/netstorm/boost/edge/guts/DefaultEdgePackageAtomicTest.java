package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public class DefaultEdgePackageAtomicTest extends LifecycleTestCase implements InjectableTest {
    EdgePackage subject;

    public void testPrefix() {
        String prefix = subject.prefix();
        assertEquals("edge", prefix);
    }
}
