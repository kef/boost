package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.pebble.inject.resolver.field.ResolverFieldFinder;
import au.net.netstorm.boost.test.automock.BoooostTestCase;

// FIX BREADCRUMB 1715 Is this really an atomic test?
public final class DefaultResolverInjectorAtomicTest extends BoooostTestCase {

    private ResolverFieldFinder fieldFinder;
    private ExplicitResolver explicitResolver;
    // FIX BREADCRUMB 1715 Re-instate.
//    private Injector subject = new ResolverInjector(fieldFinder, explicitResolver);

    public void testInjector() {
        // FIX BREADCRUMB 1715 Back here and finish.
    }
}
