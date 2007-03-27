package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRegistryMaster implements RegistryMaster {
    private final Map registrations = new HashMap();

    // FIX 32755 Throw something better than ISE.
    public Implementation getImplementation(Interface iface) {
        if (hasInstance(iface)) throw new IllegalStateException();
        return (Implementation) get(iface);
    }

    public Instance getInstance(Interface iface) {
        if (hasImplementation(iface)) throw new IllegalStateException();
        return (Instance) get(iface);
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

    private Object get(Interface type) {
        Object value = registrations.get(type);
        barfIfNull(value, type);
        return value;
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

    private void barfIfNull(Object ref, Interface iface) {
        if (ref == null) throw new UnresolvedDependencyException(iface);
    }
}
