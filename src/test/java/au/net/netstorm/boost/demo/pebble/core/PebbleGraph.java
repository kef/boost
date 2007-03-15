package au.net.netstorm.boost.demo.pebble.core;

import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;

public interface PebbleGraph {
    PebbleProviderEngine getProvider();

    Injector getInjector();
}
