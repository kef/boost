package au.net.netstorm.boost.pebble.inject.resolver.core;

public interface Registry {
    // FIX BREADCRUMB 1824 Strongly Type.
    void prototype(Class iface, Class implementation);

    // FIX BREADCRUMB 1824 Re-instate.
//    void instance(Interface iface, Instance instance);
}
