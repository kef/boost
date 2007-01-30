package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.nursery.pebble.onion.BermudaOnion;
import au.net.netstorm.boost.nursery.pebble.onion.Onion;
import au.net.netstorm.boost.nursery.pebble.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

// FIX 1665 Call this an instantiator?
public final class DefaultCreator implements Creator {
    private Implementation impl;
    private Onion onion = new BermudaOnion();
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    public DefaultCreator(Implementation impl) {
        this.impl = impl;
    }

    // FIX 1665 Should pass in instances ... not types.
    public Object create(Class[] parameters) {
        Class implClass = impl.getImpl();
        Constructor constructor = edgeClass.getConstructor(implClass, parameters);
        Object ref = edgeConstructor.newInstance(constructor, parameters);
        Interface[] implTypes = impl.getTypes();
        return onion.onionize(ref, implTypes);
    }
}
