package au.net.netstorm.boost.demo.pebble.resolve;

import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.demo.pebble.newer.DefaultPebbleProviderAssembler;
import au.net.netstorm.boost.demo.pebble.newer.PebbleProviderAssembler;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultExplicitResolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.ExplicitResolver;
import au.net.netstorm.boost.test.automock.BoooostCase;

public final class DefaultResolveDemoTest extends BoooostCase {
    private static final Object[] NO_PARAMETERS = {};
    private ExplicitResolver resolver = new DefaultExplicitResolver();
    private final PebbleProviderAssembler pebbleProviderAssembler = new DefaultPebbleProviderAssembler(resolver);
    private PebbleProvider pebbleProvider = pebbleProviderAssembler.assemble();

    {
        resolver.add(Set.class, HashSet.class);
    }

    public void testResolve() {
        if (true) return; // FIX 1715 REMOVE TO RE-INSTATE THIS ACCEPTANCE TEST!
        // FIX 1715 provide -> Pebblise.
        Rob rob = (Rob) pebbleProvider.provide(Rob.class, NO_PARAMETERS);
        Set result = rob.getSet();
        // FIX BREADCRUMB 1715 Acceptance test for this card.
        assertNotNull(result);
        assertEquals(true, result instanceof HashSet);
    }
}
