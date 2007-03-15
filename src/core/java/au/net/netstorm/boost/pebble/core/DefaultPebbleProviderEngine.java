package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.onion.Onion;
import au.net.netstorm.boost.pebble.type.Implementation;

// FIX 1715 All types must implement Pebble interface?
public final class DefaultPebbleProviderEngine implements PebbleProviderEngine {
    private Onion onion;
    private Instantiator instantiator;
    private Injector injector;

    public DefaultPebbleProviderEngine(Onion onion, Injector injector, Instantiator instantiator) {
        this.onion = onion;
        this.injector = injector;
        this.instantiator = instantiator;
    }

    public Object provide(Implementation impl, Object[] parameters) {
        Object ref = instantiator.instantiate(impl, parameters);
        injector.inject(ref); // FIX 1757 Pass in type (later).
        return onion.onionise(ref);
    }

    // FIX 1757 Remove when done.
    // FIX BREADCRUMB 1757 !!!!!!!! We probably want to onionise the Gaijins.
/*
    if (gaijin(type)) {
        return gaijiniator.instantiate(type, parameters);
    } else {
        Object ref = instantiator.instantiate(type, parameters);
        injector.inject(ref); // FIX 1757 Pass in type (later).
        return onion.onionise(ref);
    }
*/
}
