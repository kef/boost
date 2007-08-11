package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;

// FIX BREADCRUMB 2081 HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH Split into 2.

// FIX 2081 Split into map for instances and map for blueprints.
public final class DefaultRegistryMaster implements RegistryMaster {
    private final FlavouredMap web;
    TypeMaster master = new DefaultTypeMaster();

    public DefaultRegistryMaster(FlavouredMap web) {
        this.web = web;
    }

    public void blueprint(Interface iface, Blueprint blueprint, Flavour flavour) {
        barfIfNotImplOfIface(iface, blueprint);
        web.put(iface, flavour, blueprint);
    }

    public void instance(Interface iface, ResolvedInstance instance, Flavour flavour) {
        barfIfNotImplOfIface(iface, instance);
        web.put(iface, flavour, instance);
    }

    public Blueprint getBlueprint(Interface iface, Flavour flavour) {
        if (hasInstance(iface, flavour)) throw new WrongRegistrationTypeException(iface);
        return (Blueprint) get(iface, flavour);
    }

    public ResolvedInstance getInstance(Interface iface, Flavour flavour) {
        if (hasBlueprint(iface, flavour)) throw new WrongRegistrationTypeException(iface);
        return (ResolvedInstance) get(iface, flavour);
    }

    public boolean hasBlueprint(Interface iface, Flavour flavour) {
        return ofType(Blueprint.class, iface, flavour);
    }

    public boolean hasInstance(Interface iface, Flavour flavour) {
        return ofType(ResolvedInstance.class, iface, flavour);
    }

    private void barfIfNotImplOfIface(Interface iface, Blueprint blueprint) {
        Implementation impl = blueprint.getImplementation();
        barfIfNotImplOfIface(iface, impl);
    }

    private void barfIfNotImplOfIface(Interface iface, ResolvedInstance instance) {
        Object instanceRef = instance.getRef();
        Class instanceClass = instanceRef.getClass();
        Implementation impl = new DefaultImplementation(instanceClass);
        barfIfNotImplOfIface(iface, impl);
    }

    private void barfIfNotImplOfIface(Interface iface, Implementation impl) {
        if (!master.implementz(impl, iface)) throw new WrongInterfaceRegistrationException(impl, iface);
    }

    private Object get(Interface iface, Flavour flavour) {
        return web.get(iface, flavour);
    }

    private boolean ofType(Class type, Interface iface, Flavour flavour) {
        if (!web.exists(iface, flavour)) return false;
        Object value = web.get(iface, flavour);
        Class valueClass = value.getClass();
        return type.isAssignableFrom(valueClass);
    }
}