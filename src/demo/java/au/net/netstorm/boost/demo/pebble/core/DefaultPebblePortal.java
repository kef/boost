package au.net.netstorm.boost.demo.pebble.core;

import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.newer.core.InjectorEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.Registry;
import au.net.netstorm.boost.pebble.resolve.Resolver;

public final class DefaultPebblePortal implements PebblePortal {
    private final PebbleProvider provider;
    private final InjectorEngine injector;
    private final Resolver resolver;
    private final Registry registry;

    public DefaultPebblePortal(PebbleProvider provider, InjectorEngine injector, Resolver resolver, Registry registry) {
        this.provider = provider;
        this.injector = injector;
        this.resolver = resolver;
        this.registry = registry;
    }

    public PebbleProvider getProvider() {
        return provider;
    }

    public InjectorEngine getInjector() {
        return injector;
    }

    public Resolver getResolver() {
        return resolver;
    }

    public Registry getRegistry() {
        return registry;
    }
}
