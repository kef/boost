package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.inject.resolver.field.ResolverFieldFinder;
import au.net.netstorm.boost.test.automock.BoooostCase;

// FIX BREADCRUMB 1715 Is this really an atomic test?
public final class DefaultResolverInjectorAtomicTest extends BoooostCase {

    private ResolverFieldFinder fieldFinder;
    private FieldResolver fieldResolver;
    private Injector subject = new ResolverInjector(fieldFinder, fieldResolver);
    private JuicyPebble juicy = new JuicyPebble();

    public void testInjector() {
        // FIX BREADCRUMB 1715 Back here and finish.
        subject.inject(juicy);
    }
}
