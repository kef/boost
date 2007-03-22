package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1824 -99999999999 Come back here and implement!!
public interface Finder {
    boolean hasInstance(Interface iface);

    Instance getInstance(Interface iface);

    boolean hasImplementation(Interface iface);

    Implementation getImplementation(Interface iface);
}
