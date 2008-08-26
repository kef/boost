package au.net.netstorm.boost.demo.nuspider.multiplicity;

import au.net.netstorm.boost.demo.nuspider.test.NuSpiderDemooooTest;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.spider.resolve.Resolver;

public final class SingletonDemoTest extends NuSpiderDemooooTest implements HasFixtures, InjectableTest {
    Resolver resolver;
    Binder binder;

    public void setUpFixtures() {
        // FIX 2394 another use case for having: multiplicity.single(Single.class)
        binder.bind(Single.class).toSingle(DefaultSingle.class);
    }

    public void testSingleton() {
        Single one = resolver.resolve(Single.class);
        Single two = resolver.resolve(Single.class);
        assertSame(one, two);
    }
}
