package au.net.netstorm.boost.demo.pebble;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreator implements Creator {
    private Implementation impl;
    private Onion onion;
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    // FIX 1665 Wire onion dependency inside.
    public DefaultCreator(Implementation impl, Onion onion) {
        this.impl = impl;
        this.onion = onion;
    }

    public Object create(Class[] parameters) {
        Class implClass = impl.getImpl();
        Constructor constructor = edgeClass.getConstructor(implClass, parameters);
        Object ref = edgeConstructor.newInstance(constructor, parameters);
        Interface implType = impl.getType();
        return onion.onionize(ref, implType);
    }

    /*
        // FIX 1665 Should we create Resolved object?  Yes please.
        // FIX BREADCRUMB 1665 Build up the resolved object class.
        return wrap(ref, implType);
    }

    private Object wrap(Object ref, Interface type) {
        // FIX 1665 Do some proxy magic in here ;)
        throw new UnsupportedOperationException();
        // FIX 1665 Time to delegate to an onion :-)
    }
*/
}
