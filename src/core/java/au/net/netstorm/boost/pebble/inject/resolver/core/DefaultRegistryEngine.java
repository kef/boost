package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRegistryEngine implements RegistryEngine {
    private final Map map = new HashMap();

    public Implementation getImplementation(Interface type) {
        Class cls = (Class) map.get(type);
        if (cls == null) throw new UnresolvedDependencyException(type);
        return new DefaultImplementation(cls);
    }

    public void prototype(Class iface, Class implementation) {
        Interface inyerface = new DefaultInterface(iface);
        map.put(inyerface, implementation);
    }
    // FIX BREADCRUMB 1824 Re-instate.
//
//    public void instance(Class iface, Instance instance) {
//        throw new UnsupportedOperationException();
//    }
}
