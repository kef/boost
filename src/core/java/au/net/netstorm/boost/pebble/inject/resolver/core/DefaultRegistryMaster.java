package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

// FIX 32755 Should you be able to register an implementation and an instance?  I think not.

// FIX 32755 Should we barf if we attempt to insert something which already exists?
public final class DefaultRegistryMaster implements RegistryMaster {
    private final Map registrations = new HashMap();

    public Implementation getImplementation(Interface iface) {
        // FIX 32755 This should barf if the map contains a instance.
        Implementation implementation = (Implementation) registrations.get(iface);
        if (implementation == null) throw new UnresolvedDependencyException(iface);
        return implementation;
    }

    public Instance getInstance(Interface iface) {
        // FIX 32755 This should barf if the map contains an interface.
        Instance instance = (Instance) registrations.get(iface);
        if (instance == null) throw new UnresolvedDependencyException(iface);
        return instance;
    }

    public boolean hasImplementation(Interface iface) {
        return has(iface, Implementation.class);
    }

    public boolean hasInstance(Interface iface) {
        return has(iface, Instance.class);
    }

    public void implementation(Interface iface, Implementation implementation) {
        barfIfExists(iface);
        registrations.put(iface, implementation);
    }

    public void instance(Interface iface, Instance instance) {
        barfIfExists(iface);
        registrations.put(iface, instance);
    }

    private boolean has(Interface iface, Class type) {
        Object ref = registrations.get(iface);
        if (ref == null) return false;
        Class cls = ref.getClass();
        return type.isAssignableFrom(cls);
    }

    private void barfIfExists(Interface iface) {
        if (registrations.get(iface) != null) throw new AlreadyRegisteredException(iface);
    }
}
