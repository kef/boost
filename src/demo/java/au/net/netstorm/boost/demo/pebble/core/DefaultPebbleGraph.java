package au.net.netstorm.boost.demo.pebble.core;

import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;

public final class DefaultPebbleGraph implements PebbleGraph {
    private final PebbleProvider provider;
    private final Injector injector;

    public DefaultPebbleGraph(PebbleProvider provider, Injector injector) {
        this.provider = provider;
        this.injector = injector;
    }

    public PebbleProvider getProvider() {
        return provider;
    }

    public Injector getInjector() {
        return injector;
    }
}
