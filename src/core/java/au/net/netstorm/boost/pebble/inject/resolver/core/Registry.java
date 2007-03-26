package au.net.netstorm.boost.pebble.inject.resolver.core;

public interface Registry {
    void prototype(Class iface, Class impl);

    void instance(Class iface, Object ref);
}
