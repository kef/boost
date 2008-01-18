package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;

// FIX 2248 Complete.
public final class DefaultProxifierAtomicTest extends LifecycleTestCase implements InjectableTest {
    Claustrophobe claustrophobe;
    Proxifier subject;

    // FIX 2248 Pass in a Layer to proxy with!
    public void testProxy() {
        Claustrophobe closed = subject.proxy(claustrophobe);
        closed.panic();
    }
}