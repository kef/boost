package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1824 Remove once we have created the new RegistryEngne.
public interface ExplicitImplementationRegistry {
    void add(Class iface, Class implementation);

    Implementation find(Interface type);
}
