package au.net.netstorm.boost.nursery.temp;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreator implements Creator {
    private Implementation impl;
    private Onion onion = new BermudaOnion();
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    public DefaultCreator(Implementation impl) {
        this.impl = impl;
    }

    public Object create(Class[] parameters) {
        Class implClass = impl.getImpl();
        Constructor constructor = edgeClass.getConstructor(implClass, parameters);
        Object ref = edgeConstructor.newInstance(constructor, parameters);
        Interface implType = impl.getType();
        return onion.onionize(ref, implType);
    }
}
