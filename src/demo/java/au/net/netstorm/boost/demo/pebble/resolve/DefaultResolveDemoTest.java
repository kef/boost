package au.net.netstorm.boost.demo.pebble.resolve;

import java.util.Set;
import au.net.netstorm.boost.demo.pebble.newer.DefaultObjectProviderAssembler;
import au.net.netstorm.boost.demo.pebble.newer.ObjectProviderAssembler;
import au.net.netstorm.boost.pebble.newer.core.ObjectProvider;
import au.net.netstorm.boost.test.automock.BoooostTestCase;

public final class DefaultResolveDemoTest extends BoooostTestCase {
    private static final Object[] NO_PARAMETERS = {};
    private final ObjectProviderAssembler objectProviderAssembler = new DefaultObjectProviderAssembler();
    private ObjectProvider objectProvider = objectProviderAssembler.assemble();

    public void testResolve() {
        Rob rob = (Rob) objectProvider.provide(Rob.class, NO_PARAMETERS);
        Set result = rob.getSet();
        // FIX BREADCRUMB 1715 Acceptance test for this card.
//        assertNotNull(result);
    }
}
