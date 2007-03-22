package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultExplicitImplementationRegistry implements ExplicitImplementationRegistry {
    private final Map map = new HashMap();

    public Implementation find(Interface type) {
        Class cls = (Class) map.get(type);
        if (cls == null) throw new UnresolvedDependencyException(type);
        return new DefaultImplementation(cls);
    }

    public void add(Class iface, Class implementation) {
        Interface inyerface = new DefaultInterface(iface);
        map.put(inyerface, implementation);
    }
}
