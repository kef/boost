package au.net.netstorm.boost.demo.pebble.resolve;

import java.util.Set;
import au.net.netstorm.boost.demo.pebble.newer.DefaultPebbleProviderAssembler;
import au.net.netstorm.boost.demo.pebble.newer.PebbleProviderAssembler;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.test.automock.BoooostCase;

public final class DefaultResolveDemoTest extends BoooostCase {
    private static final Object[] NO_PARAMETERS = {};
    private final PebbleProviderAssembler pebbleProviderAssembler = new DefaultPebbleProviderAssembler();
    private PebbleProvider pebbleProvider = pebbleProviderAssembler.assemble();

    public void testResolve() {
        // FIX 1715 provide -> Pebblise.
        Rob rob = (Rob) pebbleProvider.provide(Rob.class, NO_PARAMETERS);
        Set result = rob.getSet();
        // FIX BREADCRUMB 1715 Acceptance test for this card.
//        assertNotNull(result);
//        assertEquals(true, result instanceof HashSet);
    }
}
