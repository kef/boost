package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.demo.pebble.core.PebbleGraph;
import au.net.netstorm.boost.demo.pebble.newer.DefaultPebbleProviderAssembler;
import au.net.netstorm.boost.demo.pebble.newer.PebbleProviderAssembler;
import au.net.netstorm.boost.pebble.core.Pebble;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultExplicitResolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.ExplicitResolver;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultResolveDemoTest extends BoooostCase {
    private static final Object[] NO_PARAMETERS = {};
    private final ExplicitResolver resolver = new DefaultExplicitResolver();
    private final PebbleProviderAssembler pebbleProviderAssembler = new DefaultPebbleProviderAssembler(Pebble.class, resolver);
    private final PebbleGraph pebbleGraph = pebbleProviderAssembler.assemble();
    private final PebbleProvider pebbleProvider = pebbleGraph.getProvider();

    {
        resolver.add(TheDude.class, JeffBridges.class);
        resolver.add(Movie.class, BigLebowski.class);
    }

    public void testSingleLevelResolve() {
        Movie movie = (Movie) pebbleProvider.provide(BigLebowski.class, NO_PARAMETERS);
        checkRealLebowski((BigLebowski) movie);
    }

    // FIX BREADCRUMB 1779 Reinstate.
//    public void testRecursiveResolve() {
//        Cinema regalCinema = (Cinema) pebbleProvider.provide(Cinema.class);
//        Movie movie = regalCinema.getMovie();
//        checkRealLebowski((BigLebowski) movie);
//    }

    private void checkRealLebowski(BigLebowski bigLebowski) {
        TheDude result = bigLebowski.getTheDude();
        assertNotNull(result);
        assertEquals(true, result instanceof JeffBridges);
    }
}
 