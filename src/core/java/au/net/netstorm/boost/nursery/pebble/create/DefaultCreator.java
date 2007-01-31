package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.nursery.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.pebble.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.nursery.pebble.onion.BermudaOnion;
import au.net.netstorm.boost.nursery.pebble.onion.Onion;

public final class DefaultCreator implements Creator {
    private Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private Onion onion = new BermudaOnion();


    public Object create(Class type, Object[] parameters) {
        Object ref = instantiator.instantiate(type, parameters);
        return onion.onionize(ref);
    }
}
