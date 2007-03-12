package au.net.netstorm.boost.pebble.create;

import au.net.netstorm.boost.pebble.create.injector.Injector;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.onion.Onion;

public final class DefaultCreator implements Creator {
    private Onion onion;
    private Instantiator instantiator;
    private Injector injector;

    public DefaultCreator(Onion onion, Injector injector, Instantiator instantiator) {
        this.onion = onion;
        this.injector = injector;
        this.instantiator = instantiator;
    }

    public Object create(Class type, Object[] parameters) {
        Object ref = instantiator.instantiate(type, parameters);
        // FIX 1715 Pass in type (later).
        injector.inject(ref);
        return onion.onionize(ref);
    }
}
