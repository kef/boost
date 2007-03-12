package au.net.netstorm.boost.pebble.create;

import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.onion.Onion;

public final class DefaultCreator implements Creator {
    private Onion onion;
    private Instantiator instantiator;
    private Injector creatorProxyInjector;

    public DefaultCreator(Onion onion, Injector creatorProxyInjector, Instantiator instantiator) {
        this.onion = onion;
        this.creatorProxyInjector = creatorProxyInjector;
        this.instantiator = instantiator;
    }

    public Object create(Class type, Object[] parameters) {
        Object ref = instantiator.instantiate(type, parameters);
        creatorProxyInjector.inject(ref);
        return onion.onionize(ref);
    }
}
