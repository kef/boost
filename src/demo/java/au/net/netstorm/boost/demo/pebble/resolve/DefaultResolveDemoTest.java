package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.demo.pebble.core.PebbleGraph;
import au.net.netstorm.boost.demo.pebble.newer.DefaultPebbleProviderAssembler;
import au.net.netstorm.boost.demo.pebble.newer.PebbleProviderAssembler;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultExplicitResolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.ExplicitResolver;
import au.net.netstorm.boost.test.automock.BoooostCase;

// FIX 1715 LAST Make sure all work resides in correct packages.
public final class DefaultResolveDemoTest extends BoooostCase {
    private static final Object[] NO_PARAMETERS = {};
    private final ExplicitResolver resolver = new DefaultExplicitResolver();
    private final PebbleProviderAssembler pebbleProviderAssembler = new DefaultPebbleProviderAssembler(resolver);
    private final PebbleGraph pebbleGraph = pebbleProviderAssembler.assemble();
    private final PebbleProvider pebbleProvider = pebbleGraph.getProvider();

    {
        resolver.add(TheDude.class, DavidPetit.class);
    }
    // FIX 1757 We need a gaijin provider for Set/HashSet.
    // FIX 1757 When you see the HashSet must have a single constructor ... remember Pebble as a marker interface.

    public void testResolve() {
        // FIX 1715 provide must implement -> Pebblise (make configurable).
        Rob rob = (Rob) pebbleProvider.provide(Rob.class, NO_PARAMETERS);
        TheDude result = rob.getTheDude();
        assertNotNull(result);
    }
}
