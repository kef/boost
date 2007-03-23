package au.net.netstorm.boost.pebble.inject.resolver.core;

public interface RegistryFacade {
    boolean hasImplementation(Class iface);

    boolean hasInstance(Class iface);
}
