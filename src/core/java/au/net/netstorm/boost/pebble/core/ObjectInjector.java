package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.inject.newer.core.Injector;

// FIX BREADCRUMB 1715 Rename to PebbleInjector.  Same for ObjectProvider.
public final class ObjectInjector implements Injector {
    private final Injector newerInjector;
    private final Injector dependencyInjector;

    public ObjectInjector(Injector newerInjector, Injector dependencyInjector) {
        this.newerInjector = newerInjector;
        this.dependencyInjector = dependencyInjector;
    }

    public void inject(Object ref) {
        newerInjector.inject(ref);
        dependencyInjector.inject(ref);
    }
}
