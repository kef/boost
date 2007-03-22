package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.demo.pebble.core.PebblePortal;
import au.net.netstorm.boost.demo.pebble.newer.DefaultPebbleAssembler;
import au.net.netstorm.boost.demo.pebble.newer.PebbleAssembler;
import au.net.netstorm.boost.pebble.core.Pebble;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultExplicitImplementationRegistry;
import au.net.netstorm.boost.pebble.inject.resolver.core.ExplicitImplementationRegistry;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultResolveDemoTest extends BoooostCase {
    private static final Object[] NO_PARAMETERS = {};
    private final ExplicitImplementationRegistry registry = new DefaultExplicitImplementationRegistry();
    private final PebbleAssembler pebbleAssembler = new DefaultPebbleAssembler(Pebble.class, registry);
    private final PebblePortal pebblePortal = pebbleAssembler.assemble();
    private final PebbleProvider pebbleProvider = pebblePortal.getProvider();

    {
        registry.add(TheDude.class, JeffBridges.class);
        registry.add(Quote.class, ClassicQuote.class);
        registry.add(Movie.class, BigLebowski.class);
        registry.add(Cinema.class, RegalCinema.class);
    }

    public void testNoArgProvide() {
        TheDude theDude = (TheDude) pebbleProvider.provide(JeffBridges.class, NO_PARAMETERS);
        checkTheDudeIsReallyJeff(theDude);
    }

    public void testProvide() {
        Cinema regalCinema = (Cinema) pebbleProvider.provide(RegalCinema.class, NO_PARAMETERS);
        assertNotNull(regalCinema);
    }

    private void checkTheDudeIsReallyJeff(TheDude theDude) {
        assertNotNull(theDude);
        assertEquals(true, theDude instanceof JeffBridges);
        Quote quote = theDude.getQuote();
        assertNotNull(quote);
    }
}
 