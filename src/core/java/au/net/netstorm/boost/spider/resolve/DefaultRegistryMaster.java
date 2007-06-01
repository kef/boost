package au.net.netstorm.boost.spider.resolve;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.inject.resolver.core.AlreadyRegisteredException;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// DEBT DataAbstractionCoupling {
public final class DefaultRegistryMaster implements RegistryMaster {
    private final Map web = new HashMap();

    public void multiple(Interface iface, Implementation implementation, Flavour flavour) {
        barfIfExists(iface);
        barfIfNotImplOfIface(iface, implementation);
        web.put(iface, implementation);
    }

    public void instance(Interface iface, ResolvedInstance instance, Flavour flavour) {
        barfIfInstanceIsClass(instance);
        barfIfNotImplOfIface(iface, instance);
        barfIfExists(iface);
        web.put(iface, instance);
    }

    public Implementation getImplementation(Interface iface, Flavour flavour) {
        if (hasInstance(iface, flavour)) throw new WrongRegistrationTypeException(iface);
        return (Implementation) get(iface);
    }

    public ResolvedInstance getInstance(Interface iface, Flavour flavour) {
        if (hasImplementation(iface, flavour)) throw new WrongRegistrationTypeException(iface);
        return (ResolvedInstance) get(iface);
    }

    public boolean hasImplementation(Interface iface, Flavour flavour) {
        return has(iface, Implementation.class);
    }

    public boolean hasInstance(Interface iface, Flavour flavour) {
        return has(iface, ResolvedInstance.class);
    }

    private void barfIfNotImplOfIface(Interface iface, ResolvedInstance instance) {
        Object instanceRef = instance.getRef();
        Class instanceClass = instanceRef.getClass();
        Implementation impl = new DefaultImplementation(instanceClass);
        barfIfNotImplOfIface(iface, impl);
    }

    private void barfIfNotImplOfIface(Interface iface, Implementation impl) {
        if (!impl.is(iface)) throw new WrongInterfaceRegistrationException(impl, iface);
    }

    private void barfIfInstanceIsClass(ResolvedInstance instance) {
        Object ref = instance.getRef();
        if (ref instanceof Class) {
            throw new WrongInstanceTypeException(ref + " is a class and cannot be registered as an instance.");
        }
    }

    private Object get(Interface iface) {
        Object value = web.get(iface);
        barfIfNull(value, iface);
        return value;
    }

    private boolean has(Interface iface, Class type) {
        return checkRegister(iface, type);
    }

    private boolean checkRegister(Interface iface, Class type) {
        Object ref = web.get(iface);
        if (ref == null) return false;
        Class cls = ref.getClass();
        return type.isAssignableFrom(cls);
    }

    private void barfIfExists(Interface iface) {
        if (web.get(iface) != null) throw new AlreadyRegisteredException(iface);
    }

    private void barfIfNull(Object ref, Interface iface) {
        if (ref == null) throw new UnresolvedDependencyException(iface);
    }
}
// } DEBT DataAbstractionCoupling