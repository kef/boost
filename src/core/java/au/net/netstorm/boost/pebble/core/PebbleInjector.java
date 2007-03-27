package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class PebbleInjector implements Injector {
    private final Injector newerInjector;
    private final Injector resolverInjector;

    public PebbleInjector(Injector newerInjector, Injector resolverInjector) {
        this.newerInjector = newerInjector;
        this.resolverInjector = resolverInjector;
    }

    public void inject(UnresolvedInstance unresolved) {
        newerInjector.inject(unresolved);
        resolverInjector.inject(unresolved);
    }
}
