package au.net.netstorm.boost.demo.pebble;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;

public final class DefaultCreator implements Creator {
    private Implementation impl;
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    public DefaultCreator(Class type) {
    }

/*
    public DefaultCreator(Implementation impl) {
        this.impl = impl;
    }
    
    Object create(Class[] parameters) {
        Class implClass = impl.getImpl();
        Constructor constructor = edgeClass.getConstructor(implClass, parameters);
        Object ref = edgeConstructor.newInstance(constructor, parameters);
        // FIX 1665 Should we create Resolved object?  Yes please.
        // FIX BREADCRUMB 1665 Build up the resolved object class.
        Interface implType = impl.getType();
        return wrap(ref, implType);
    }

    private Object wrap(Object ref, Interface type) {
        // FIX 1665 Do some proxy magic in here ;)
        throw new UnsupportedOperationException();
        // FIX 1665 Time to delegate to an onion :-)
    }
*/
}
