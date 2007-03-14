package au.net.netstorm.boost.pebble.inject.resolver.core;

public interface ExplicitResolver extends Resolver {
    void add(Class iface, Class implementation);
}
