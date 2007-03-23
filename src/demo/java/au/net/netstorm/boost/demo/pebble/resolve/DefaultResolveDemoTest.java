package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.demo.pebble.core.PebblePortal;
import au.net.netstorm.boost.demo.pebble.newer.DefaultPebbleAssembler;
import au.net.netstorm.boost.demo.pebble.newer.PebbleAssembler;
import au.net.netstorm.boost.pebble.core.Pebble;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.resolver.core.RegistryEngine;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultResolveDemoTest extends BoooostCase {
    private static final Object[] NO_PARAMETERS = {};
    private final PebbleAssembler pebbleAssembler = new DefaultPebbleAssembler(Pebble.class);
    private final PebblePortal pebblePortal = pebbleAssembler.assemble();
    private final PebbleProvider pebbleProvider = pebblePortal.getProvider();
    private final RegistryEngine registryEngine = pebblePortal.getRegistry();

    {
        registryEngine.prototype(TheDude.class, JeffBridges.class);
        registryEngine.prototype(Quote.class, ClassicQuote.class);
        registryEngine.prototype(Movie.class, BigLebowski.class);
        registryEngine.prototype(Cinema.class, RegalCinema.class);
        registryEngine.instance(Actor.class, new PeterSellers());
        registryEngine.instance(Celebrity.class, new BritneySpears());
        registryEngine.prototype(Hollywood.class, GlitzyHollywood.class);
    }

    public void testNoArgProvide() {
        TheDude theDude = (TheDude) pebbleProvider.provide(JeffBridges.class, NO_PARAMETERS);
        checkTheDudeIsReallyJeff(theDude);
    }

    public void testProvide() {
        Cinema regalCinema = (Cinema) pebbleProvider.provide(RegalCinema.class, NO_PARAMETERS);
        assertNotNull(regalCinema);
    }

    public void testProvideSingleton() {
        // FIX BREADCRUMB 1824 Complete me! Test singleton!
//        Hollywood hollywood = (Hollywood) pebbleProvider.provide(GlitzyHollywood.class, NO_PARAMETERS);
//        assertNotNull(hollywood);
    }

    private void checkTheDudeIsReallyJeff(TheDude theDude) {
        assertNotNull(theDude);
        assertEquals(true, theDude instanceof JeffBridges);
        Quote quote = theDude.getQuote();
        assertNotNull(quote);
    }
}
 