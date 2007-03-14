package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.pebble.type.DefaultImplementation;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultExplicitResolver implements ExplicitResolver {
    private final Map map = new HashMap();

    public Implementation resolve(Interface type) {
        Class key = type.getType();
        Class cls = (Class) map.get(key);
        return new DefaultImplementation(cls);
    }

    public void add(Class iface, Class implementation) {
        map.put(iface, implementation);
    }
}
