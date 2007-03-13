package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.inject.newer.core.Injector;

// FIX BREADCRUMB 1715 Rename to PebbleInjector.  Same for ObjectProvider.
public final class PebbleInjector implements Injector {
    private final Injector newerInjector;
    private final Injector resolverInjector;

    public PebbleInjector(Injector newerInjector, Injector resolverInjector) {
        this.newerInjector = newerInjector;
        this.resolverInjector = resolverInjector;
    }

    public void inject(Object ref) {
        newerInjector.inject(ref);
        resolverInjector.inject(ref);
    }
}
