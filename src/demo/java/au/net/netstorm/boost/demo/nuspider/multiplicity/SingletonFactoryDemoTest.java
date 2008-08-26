package au.net.netstorm.boost.demo.nuspider.multiplicity;

import au.net.netstorm.boost.demo.nuspider.test.NuSpiderDemooooTest;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.SingletonImplicitFactory;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.spider.resolve.Resolver;

// FIX 2394 Driving out an implicit singleton factory.
// FIX 2394 Rework once ideas are formalized.
public final class SingletonFactoryDemoTest extends NuSpiderDemooooTest implements HasFixtures, InjectableTest {
    Resolver resolver;
    Binder binder;
    Web web;

    public void setUpFixtures() {
        web.register(SingletonImplicitFactory.class);
        binder.bind(MultiHolderThingo.class).to(DefaultHolderThingo.class);
    }

    public void testSingleton() {
        Single one = resolver.resolve(Single.class);
        Single two = resolver.resolve(Single.class);
        assertSame(one, two);
    }

    public void testNested() {
        HolderThingo one = resolver.resolve(HolderThingo.class);
        HolderThingo two = resolver.resolve(HolderThingo.class);
        assertSame(one, two);
        assertSame(one.single(), two.single());
    }

    public void testNestedInMulti() {
        MultiHolderThingo one = resolver.resolve(MultiHolderThingo.class);
        MultiHolderThingo two = resolver.resolve(MultiHolderThingo.class);
        assertNotSame(one, two);
        assertSame(one.single(), two.single());
    }
}