package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.pebble.type.DefaultImplementation;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultExplicitResolver implements ExplicitResolver {
    private final Map map = new HashMap();

    public Implementation resolve(Interface type) {
        Class cls = (Class) map.get(type);
        // FIX 1715 Throw a not resolved exception.
        if (cls == null) throw new IllegalStateException("Cannot resolve " + type);
        return new DefaultImplementation(cls);
    }

    public void add(Class iface, Class implementation) {
        Interface inyerface = new DefaultInterface(iface);
        map.put(inyerface, implementation);
    }
}
