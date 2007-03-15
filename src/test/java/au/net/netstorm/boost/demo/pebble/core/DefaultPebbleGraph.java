package au.net.netstorm.boost.demo.pebble.core;

import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;

public final class DefaultPebbleGraph implements PebbleGraph {
    private final PebbleProviderEngine provider;
    private final Injector injector;

    public DefaultPebbleGraph(PebbleProviderEngine provider, Injector injector) {
        this.provider = provider;
        this.injector = injector;
    }

    public PebbleProviderEngine getProvider() {
        return provider;
    }

    public Injector getInjector() {
        return injector;
    }
}
