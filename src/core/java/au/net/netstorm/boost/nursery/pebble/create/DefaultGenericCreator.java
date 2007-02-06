package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.nursery.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.pebble.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.nursery.pebble.onion.BermudaOnion;
import au.net.netstorm.boost.nursery.pebble.onion.Onion;

// FIX 1665 This is an instantiator (not a creator)?
public final class DefaultGenericCreator implements GenericCreator {
    private Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private Onion onion = new BermudaOnion();

    public Object create(Class type, Object[] parameters) {
        Object ref = instantiator.instantiate(type, parameters);
        // FIX 1665 Probably we should be onionizing outside of here.
        return onion.onionize(ref);
    }
}
