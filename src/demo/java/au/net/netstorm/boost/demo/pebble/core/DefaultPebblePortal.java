package au.net.netstorm.boost.demo.pebble.core;

import au.net.netstorm.boost.pebble.core.Provider;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.inject.resolver.core.Registry;
import au.net.netstorm.boost.pebble.resolve.Resolver;

public final class DefaultPebblePortal implements PebblePortal {
    private final Provider provider;
    private final Injector injector;
    private final Resolver resolver;
    private final Registry registry;

    public DefaultPebblePortal(Provider provider, Injector injector, Resolver resolver, Registry registry) {
        this.provider = provider;
        this.injector = injector;
        this.resolver = resolver;
        this.registry = registry;
    }

    public Provider getProvider() {
        return provider;
    }

    public Injector getInjector() {
        return injector;
    }

    public Resolver getResolver() {
        return resolver;
    }

    public Registry getRegistry() {
        return registry;
    }
}
