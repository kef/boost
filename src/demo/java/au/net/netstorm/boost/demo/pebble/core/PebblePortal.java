package au.net.netstorm.boost.demo.pebble.core;

import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.newer.core.InjectorEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.Registry;
import au.net.netstorm.boost.pebble.resolve.Resolver;

public interface PebblePortal {
    // FIX 32755 Rename to just Provider.
    PebbleProvider getProvider();

    // FIX 32755 Drive up an injector and stitch in.
    InjectorEngine getInjector();

    Resolver getResolver();

    Registry getRegistry();
}
