package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.onion.Onion;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultPebbleProviderEngine implements PebbleProviderEngine {
    private final Interface marker;
    private Onion onion;
    private Instantiator instantiator;
    private Injector injector;

    public DefaultPebbleProviderEngine(Interface marker, Onion onion, Injector injector, Instantiator instantiator) {
        this.marker = marker;
        this.onion = onion;
        this.injector = injector;
        this.instantiator = instantiator;
    }

    // SUGGEST: Strongly type Object[] as Dependencies?
    public Instance provide(Implementation impl, Object[] resolved) {
        if (!impl.is(marker)) throw new IllegalCitizenException(marker, impl);
        Object ref = instantiator.instantiate(impl, resolved);
        injector.inject(ref);
        return onion.onionise(ref);
    }

    // FIX 1757 Remove when done.
    // FIX BREADCRUMB 1757 !!!!!!!! We probably want to onionise the Gaijins.
    // FIX 1757 Pebble provider should remain pure.  Front-end.
    // FIX 1757 We need a gaijin provider for Set/HashSet.
    // FIX 1757 When you see the HashSet must have a single constructor ... remember Pebble as a marker interface.

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
