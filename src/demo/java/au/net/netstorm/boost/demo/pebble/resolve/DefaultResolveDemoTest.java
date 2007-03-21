package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.demo.pebble.core.PebblePortal;
import au.net.netstorm.boost.demo.pebble.newer.DefaultPebbleAssembler;
import au.net.netstorm.boost.demo.pebble.newer.PebbleAssembler;
import au.net.netstorm.boost.pebble.core.Pebble;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultExplicitImplementationLookup;
import au.net.netstorm.boost.pebble.inject.resolver.core.ExplicitImplementationLookup;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultResolveDemoTest extends BoooostCase {
    private static final Object[] NO_PARAMETERS = {};
    private final ExplicitImplementationLookup lookup = new DefaultExplicitImplementationLookup();
    private final PebbleAssembler pebbleAssembler = new DefaultPebbleAssembler(Pebble.class, lookup);
    private final PebblePortal pebblePortal = pebbleAssembler.assemble();
    private final PebbleProvider pebbleProvider = pebblePortal.getProvider();

    {
        lookup.add(TheDude.class, JeffBridges.class);
        lookup.add(Quote.class, ClassicQuote.class);
        lookup.add(Movie.class, BigLebowski.class);
        lookup.add(Cinema.class, RegalCinema.class);
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
 