package au.net.netstorm.boost.spider.resolve;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import au.net.netstorm.boost.spider.inject.newer.DefaultNewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.NewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.core.Newer;
import au.net.netstorm.boost.spider.inject.resolver.core.AlreadyRegisteredException;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// DEBT DataAbstractionCoupling {
public final class DefaultRegistryMaster implements RegistryMaster {
    private static final Interface NEWER = new DefaultInterface(Newer.class);
    private final Map registrations = new HashMap();
    private final NewerAssembler newerAssembler = new DefaultNewerAssembler();

    public void implementation(Interface iface, Implementation implementation) {
        barfIfExists(iface);
        registrations.put(iface, implementation);
    }

    public void instance(Interface iface, ResolvedInstance instance) {
        barfIfInstanceIsClass(instance);
        barfIfExists(iface);
        registrations.put(iface, instance);
    }

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

    public Interface[] getKeys() {
        Set set = registrations.keySet();
        return (Interface[]) set.toArray(new Interface[]{});
    }

    private boolean isANewer(Interface iface) {
        return iface.is(NEWER);
    }

    private void barfIfInstanceIsClass(ResolvedInstance instance) {
        Object ref = instance.getRef();
        if (ref instanceof Class) {
            throw new WrongInstanceTypeException(ref + " is a class and cannot be registered as an instance.");
        }
    }

    private Object get(Interface type) {
        if (isANewer(type)) return newerAssembler.assemble(type);
        Object value = registrations.get(type);
        barfIfNull(value, type);
        return value;
    }

    private boolean has(Interface iface, Class type) {
        if (isANewer(iface)) return true;
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
// } DEBT DataAbstractionCoupling