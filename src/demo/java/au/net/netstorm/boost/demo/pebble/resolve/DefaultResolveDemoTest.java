package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.demo.pebble.core.PebblePortal;
import au.net.netstorm.boost.demo.pebble.newer.DefaultPebbleAssembler;
import au.net.netstorm.boost.demo.pebble.newer.PebbleAssembler;
import au.net.netstorm.boost.pebble.core.Pebble;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultRegistryEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultRegistryFacade;
import au.net.netstorm.boost.pebble.inject.resolver.core.RegistryEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.RegistryFacade;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultResolveDemoTest extends BoooostCase {
    private static final Object[] NO_PARAMETERS = {};
    private final RegistryEngine registryEngine = new DefaultRegistryEngine();
    private final RegistryFacade registryFacade = new DefaultRegistryFacade(registryEngine);
    private final PebbleAssembler pebbleAssembler = new DefaultPebbleAssembler(Pebble.class, registryFacade);
    private final PebblePortal pebblePortal = pebbleAssembler.assemble();
    private final PebbleProvider pebbleProvider = pebblePortal.getProvider();

    {
        registryFacade.prototype(TheDude.class, JeffBridges.class);
        registryFacade.prototype(Quote.class, ClassicQuote.class);
        registryFacade.prototype(Movie.class, BigLebowski.class);
        registryFacade.prototype(Cinema.class, RegalCinema.class);
        registryFacade.instance(Actor.class, new PeterSellers());
        registryFacade.instance(Celebrity.class, new BritneySpears());
        registryFacade.prototype(Hollywood.class, GlitzyHollywood.class);
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
 