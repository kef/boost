package au.net.netstorm.boost.demo.pebble.core;

import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.resolve.Resolver;

public final class DefaultPebblePortal implements PebblePortal {
    private final PebbleProvider provider;
    private final Injector injector;
    private final Resolver resolver;

    public DefaultPebblePortal(PebbleProvider provider, Injector injector, Resolver resolver) {
        this.provider = provider;
        this.injector = injector;
        this.resolver = resolver;
    }

    public PebbleProvider getProvider() {
        return provider;
    }

    public Injector getInjector() {
        return injector;
    }

    public Resolver getResolver() {
        return resolver;
    }
}
