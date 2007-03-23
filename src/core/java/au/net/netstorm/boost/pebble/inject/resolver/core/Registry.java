package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public interface Registry {
    // FIX BREADCRUMB 1824 Strongly Type.
    void prototype(Interface iface, Implementation implementation);

    void instance(Interface iface, Instance instance);
}
