package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;

// FIX ()  2255 Complete me.
public final class CyclicProxyResolvingAtomicTest extends LifecycleTestCase implements InjectableTest {
    Resolver subject;
    Registry registry;

    // FIX ()  2255 Put some assertions in here.
    public void test() {
        registry.layer(DefaultHate.class, LoveToHateLayer.class);
        subject.resolve(Love.class);
    }
}