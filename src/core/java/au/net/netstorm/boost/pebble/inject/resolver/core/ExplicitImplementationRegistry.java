package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface ExplicitImplementationRegistry {
    void add(Class iface, Class implementation);

    Implementation find(Interface type);
}
