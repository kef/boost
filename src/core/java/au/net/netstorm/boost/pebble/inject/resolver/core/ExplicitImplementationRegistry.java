package au.net.netstorm.boost.pebble.inject.resolver.core;

public interface ExplicitImplementationRegistry extends ImplementationRegistry {
    void add(Class iface, Class implementation);
}
