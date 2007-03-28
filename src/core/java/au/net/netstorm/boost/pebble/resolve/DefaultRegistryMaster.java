package au.net.netstorm.boost.pebble.resolve;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.pebble.inject.resolver.core.AlreadyRegisteredException;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistryMaster implements RegistryMaster {
    private final Map registrations = new HashMap();

    public Implementation getImplementation(Interface iface) {
        if (hasInstance(iface)) throw new WrongRegistrationTypeException(iface);
        return (Implementation) get(iface);
    }

    public ResolvedInstance getInstance(Interface iface) {
        if (hasImplementation(iface)) throw new WrongRegistrationTypeException(iface);
        return (ResolvedInstance) get(iface);
    }

    public boolean hasImplementation(Interface iface) {
        return has(iface, Implementation.class);
    }

    public boolean hasInstance(Interface iface) {
        return has(iface, ResolvedInstance.class);
    }

    public void implementation(Interface iface, Implementation implementation) {
        barfIfExists(iface);
        registrations.put(iface, implementation);
    }

    public void instance(Interface iface, ResolvedInstance instance) {
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
