package au.net.netstorm.boost.demo.pebble.resolve.singleton;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface ExplicitInstanceRegistry {
    void add(Class iface, Object ref);

    Implementation find(Interface type);
}
