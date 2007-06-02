package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.DefaultFlavouredMap;
import au.net.netstorm.boost.spider.flavour.DefaultFlavouredMapEngine;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.spider.flavour.FlavouredMapEngine;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX BREADCRUMB 1977 HHHHHHHHHHHHHHHHHHHHHH Stitch in FlavouredMap.

// DEBT DataAbstractionCoupling {
public final class DefaultRegistryMaster implements RegistryMaster {
    // FIX 1977 Pass in a flavoured map.  Construct in spider area.
    private final FlavouredMapEngine engine = new DefaultFlavouredMapEngine();
    private final FlavouredMap web = new DefaultFlavouredMap(engine);

    public void multiple(Interface iface, Implementation implementation, Flavour flavour) {
        barfIfNotImplOfIface(iface, implementation);
        web.put(iface, flavour, implementation);
    }

    public void instance(Interface iface, ResolvedInstance instance, Flavour flavour) {
        barfIfInstanceIsClass(instance);
        barfIfNotImplOfIface(iface, instance);
        web.put(iface, flavour, instance);
    }

    public Implementation getImplementation(Interface iface, Flavour flavour) {
        if (hasInstance(iface, flavour)) throw new WrongRegistrationTypeException(iface);
        return (Implementation) get(iface, flavour);
    }

    public ResolvedInstance getInstance(Interface iface, Flavour flavour) {
        if (hasImplementation(iface, flavour)) throw new WrongRegistrationTypeException(iface);
        return (ResolvedInstance) get(iface, flavour);
    }

    public boolean hasImplementation(Interface iface, Flavour flavour) {
        return has(iface, flavour, Implementation.class);
    }

    public boolean hasInstance(Interface iface, Flavour flavour) {
        return has(iface, flavour, ResolvedInstance.class);
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

    private Object get(Interface iface, Flavour flavour) {
        Object value = web.get(iface, flavour);
        barfIfNull(value, iface);
        return value;
    }

    private boolean has(Interface iface, Flavour flavour, Class type) {
        return checkRegister(iface, flavour, type);
    }

    private boolean checkRegister(Interface iface, Flavour flavour, Class type) {
        Object ref = web.get(iface, flavour);
        if (ref == null) return false;
        Class cls = ref.getClass();
        return type.isAssignableFrom(cls);
    }

    private void barfIfNull(Object ref, Interface iface) {
        if (ref == null) throw new UnresolvedDependencyException(iface);
    }
}
// } DEBT DataAbstractionCoupling