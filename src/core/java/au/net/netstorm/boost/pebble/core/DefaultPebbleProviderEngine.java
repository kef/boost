package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.inject.core.InjectorEngine;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.onion.Onionizer;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultPebbleProviderEngine implements PebbleProviderEngine {
    private final Interface marker;
    private Onionizer onionizer;
    private Instantiator instantiator;
    private InjectorEngine injector;

    // OK LineLength {
    public DefaultPebbleProviderEngine(Interface marker, Onionizer onionizer, InjectorEngine injector, Instantiator instantiator) {
        this.marker = marker;
        this.onionizer = onionizer;
        this.injector = injector;
        this.instantiator = instantiator;
    }
    // } OK LineLength 

    // SUGGEST: Strongly type Object[] as Dependencies?

    public ResolvedInstance provide(Implementation impl, Object[] parameters) {
        if (!impl.is(marker)) throw new IllegalCitizenException(marker, impl);
        UnresolvedInstance unresolved = instantiator.instantiate(impl, parameters);
        injector.inject(unresolved);
        ResolvedInstance resolved = (ResolvedInstance) unresolved;
        return onionizer.onionise(resolved);
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
