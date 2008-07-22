package au.net.netstorm.boost.demo.nuspider.lifecycle.pokeable;

import au.net.netstorm.boost.demo.nuspider.test.NuSpiderDemooooTest;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.resolve.Resolver;

public final class PokeableDemoTest extends NuSpiderDemooooTest implements HasFixtures, InjectableTest {
    Resolver resolver;
    Binder binder;

    public void setUpFixtures() {
        binder.bind(PokeableMulti.class).to(DefaultPokeableThing.class);
        binder.bind(PokeableSingle.class).toSingle(DefaultPokeableThing.class);
    }

    public void testPokeMultiton() {
        checkPokeCount(1, PokeableMulti.class);
        checkPokeCount(1, PokeableMulti.class);
    }

    public void testPokeSingleton() {
        checkPokeCount(1, PokeableSingle.class);
        checkPokeCount(2, PokeableSingle.class);
    }

    private void checkPokeCount(int expected, Class<? extends PokeableThing> type) {
        PokeableThing thing = resolver.resolve(type);
        checkPokeCount(expected, thing);
    }

    private void checkPokeCount(int expected, PokeableThing thing) {
        int actual = thing.pokeCount();
        assertEquals(expected, actual);
    }
}
