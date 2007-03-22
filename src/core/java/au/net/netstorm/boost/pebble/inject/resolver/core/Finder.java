package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public interface Finder {
    Implementation getImplementation(Interface iface);

    // FIX BREADCRUMB 1824 Re-instate.
//    boolean hasInstance(Interface iface);

    //
    Instance getInstance(Interface iface);
//
//    boolean hasImplementation(Interface iface);
//
}
