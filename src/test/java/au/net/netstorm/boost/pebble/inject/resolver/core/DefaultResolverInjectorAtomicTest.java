package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.inject.resolver.field.ResolverFieldFinder;
import au.net.netstorm.boost.test.automock.BoooostTestCase;

// FIX BREADCRUMB 1715 Is this really an atomic test?
public final class DefaultResolverInjectorAtomicTest extends BoooostTestCase {

    private ResolverFieldFinder fieldFinder;
    private ExplicitResolver explicitResolver;
    private Injector subject = new ResolverInjector(fieldFinder, explicitResolver);
    private JuicyPebble juicy = new JuicyPebble();

    public void testInjector() {
        // FIX BREADCRUMB 1715 Back here and finish.
        subject.inject(juicy);
    }
}
