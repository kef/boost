package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class DefaultEdgePackageAtomicTest extends LifecycleTestCase implements InjectableTest {
    EdgePackage subject;

    public void testPrefix() {
        String prefix = subject.prefix();
        assertEquals("edge", prefix);
    }
}
