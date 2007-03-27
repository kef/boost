package au.net.netstorm.boost.demo.pebble.core;

import au.net.netstorm.boost.pebble.core.Provider;
import au.net.netstorm.boost.pebble.inject.core.Injector;
import au.net.netstorm.boost.pebble.inject.resolver.core.Registry;
import au.net.netstorm.boost.pebble.resolve.Resolver;

public interface PebblePortal {
    Provider getProvider();

    Injector getInjector();

    Resolver getResolver();

    Registry getRegistry();
}
