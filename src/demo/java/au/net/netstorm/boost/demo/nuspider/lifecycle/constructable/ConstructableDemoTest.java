package au.net.netstorm.boost.demo.nuspider.lifecycle.constructable;

import au.net.netstorm.boost.demo.nuspider.test.NuSpiderDemooooTest;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class ConstructableDemoTest extends NuSpiderDemooooTest implements HasFixtures, InjectableTest {
    Resolver resolver;
    Binder binder;

    public void setUpFixtures() {
        binder.bind(ConstructableMulti.class).to(DefaultConstructableThing.class);
        binder.bind(ConstructableSingle.class).toSingle(DefaultConstructableThing.class);
    }

    public void testConstructMultiton() {
        checkConstructCount(1, ConstructableMulti.class);
        checkConstructCount(1, ConstructableMulti.class);
    }

    public void testConstructSingleton() {
        checkConstructCount(1, ConstructableSingle.class);
        checkConstructCount(1, ConstructableSingle.class);
    }

    private void checkConstructCount(int expected, Class<? extends ConstructableThing> type) {
        ConstructableThing thing = resolver.resolve(type);
        checkConstructCount(expected, thing);
    }

    private void checkConstructCount(int expected, ConstructableThing thing) {
        int actual = thing.constructionCount();
        assertEquals(expected, actual);
    }
}
