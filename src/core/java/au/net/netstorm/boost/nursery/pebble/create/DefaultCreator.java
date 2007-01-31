package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.nursery.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.pebble.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.nursery.pebble.onion.BermudaOnion;
import au.net.netstorm.boost.nursery.pebble.onion.Onion;
import au.net.netstorm.boost.nursery.pebble.type.Implementation;

// FIX 1665 Build up an instantiator.  This then delegates to the instantiator and the onion.
public final class DefaultCreator implements Creator {
    private Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private Implementation impl;
    private Onion onion = new BermudaOnion();
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();


    public Object create(Class type, Object[] parameters) {
//        Object ref = instantiator.instantiate(type, parameters);
//        onion.onionize(ref, )
        return null;
    }
}
