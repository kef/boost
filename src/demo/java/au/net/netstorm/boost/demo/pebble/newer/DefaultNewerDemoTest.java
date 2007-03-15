package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.demo.pebble.core.PebbleGraph;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultExplicitResolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.Resolver;
import junit.framework.TestCase;

public final class DefaultNewerDemoTest extends TestCase {
    private static final Object[] NO_PARAMETERS = new Object[]{};
    private final Resolver resolver = new DefaultExplicitResolver();
    private final PebbleProviderAssembler pebbleProviderAssembler = new DefaultPebbleProviderAssembler(resolver);
    private final PebbleGraph pebbleGraph = pebbleProviderAssembler.assemble();
    private final PebbleProviderEngine pebbleProvider = pebbleGraph.getProvider();

    public void testRecursiveNewerInjection() {
        Rob rob = (Rob) pebbleProvider.provide(Rob.class, NO_PARAMETERS);
        Bob bob = rob.getBob();
        checkNewersRecurse(bob);
    }

    private void checkNewersRecurse(Bob bob) {
        NewHeadJob newJobNewer = bob.getNewHeadJob();
        checkCreatedRecursively(newJobNewer);
    }

    private void checkCreatedRecursively(Object ref) {
        assertNotNull(ref);
    }
}
