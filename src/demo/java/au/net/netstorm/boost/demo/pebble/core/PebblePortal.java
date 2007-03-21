package au.net.netstorm.boost.demo.pebble.core;

import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.resolve.Resolver;

// FIX 1779 Add getResolver.

public interface PebblePortal {
    PebbleProvider getProvider();

    Injector getInjector();

    Resolver getResolver();
}
