package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.inject.resolver.field.ResolverFieldFinder;

public final class ResolverInjector implements Injector {
    private final ResolverFieldFinder fieldFinder;
    private final Resolver resolver;

    public ResolverInjector(ResolverFieldFinder fieldFinder, Resolver resolver) {
        this.fieldFinder = fieldFinder;
        this.resolver = resolver;
    }

    public void inject(Object object) {
        // FIX 1715 Do this.
        // FIX 1715 Nail 4 next.
        // 1. For each candidate field.
        // 2. Determine field interface.
        // 4. Instantiate implementation.
        // 5. Set field.
    }
}
