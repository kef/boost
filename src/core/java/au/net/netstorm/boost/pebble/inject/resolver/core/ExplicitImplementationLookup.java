package au.net.netstorm.boost.pebble.inject.resolver.core;

public interface ExplicitImplementationLookup extends ImplementationLookup {
    void add(Class iface, Class implementation);
}
