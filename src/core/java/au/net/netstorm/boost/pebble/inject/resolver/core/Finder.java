package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface Finder {
    boolean hasInstance(Interface iface);

//    Instance getInstance(Interface iface);

    boolean hasImplementation(Interface iface);

    Implementation getImplementation(Interface iface);
}
