package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.Instance;

public interface Registry {
    // FIX BREADCRUMB 1824 Strongly Type.
    void prototype(Class iface, Class implementation);

    void instance(Class iface, Instance instance);
}
