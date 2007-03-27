package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.inject.newer.core.InjectorEngine;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class PebbleInjectorEngine implements InjectorEngine {
    private final InjectorEngine newerInjector;
    private final InjectorEngine resolverInjector;

    public PebbleInjectorEngine(InjectorEngine newerInjector, InjectorEngine resolverInjector) {
        this.newerInjector = newerInjector;
        this.resolverInjector = resolverInjector;
    }

    public void inject(UnresolvedInstance unresolved) {
        newerInjector.inject(unresolved);
        resolverInjector.inject(unresolved);
    }
}
