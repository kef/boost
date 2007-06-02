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

public final class DefaultRegistryMaster implements RegistryMaster {
    // FIX 1977 Pass in a flavoured map.  Construct in spider area.
    private final FlavouredMapEngine engine = new DefaultFlavouredMapEngine();
    private final FlavouredMap web = new DefaultFlavouredMap(engine);

    public void multiple(Interface iface, Implementation implementation, Flavour flavour) {
        barfIfNotImplOfIface(iface, implementation);
        web.put(iface, flavour, implementation);
    }

    public void instance(Interface iface, ResolvedInstance instance, Flavour flavour) {
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
        return ofType(Implementation.class, iface, flavour);
    }

    public boolean hasInstance(Interface iface, Flavour flavour) {
        return ofType(ResolvedInstance.class, iface, flavour);
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

    private Object get(Interface iface, Flavour flavour) {
        return web.get(iface, flavour);
    }

    private boolean ofType(Class type, Interface iface, Flavour flavour) {
        Object value = web.get(iface, flavour);
        Class valueClass = value.getClass();
        return type.isAssignableFrom(valueClass);
    }
}