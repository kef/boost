package au.net.netstorm.boost.demo.pebble.core;

import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;

public interface PebblePortal {
    PebbleProvider getProvider();

    Injector getInjector();
}
