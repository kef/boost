package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInstance;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1824 This should only have the methods prototype and instance, the others can go.
public final class DefaultRegistry implements Registry {
    private final RegisterMaster registerMaster;

    public DefaultRegistry(RegisterMaster registerMaster) {
        this.registerMaster = registerMaster;
    }

    public boolean hasImplementation(Interface iface) {
        return registerMaster.hasImplementation(iface);
    }

    public boolean hasInstance(Interface iface) {
        return registerMaster.hasInstance(iface);
    }

    public Implementation getImplementation(Interface iface) {
        return registerMaster.getImplementation(iface);
    }

    public Instance getInstance(Interface iface) {
        return registerMaster.getInstance(iface);
    }

    public void prototype(Class iface, Class impl) {
        Interface inyerface = new DefaultInterface(iface);
        Implementation implementation = new DefaultImplementation(impl);
        registerMaster.prototype(inyerface, implementation);
    }

    public void instance(Class iface, Object ref) {
        Interface inyerface = new DefaultInterface(iface);
        Instance instance = new DefaultInstance(ref);
        registerMaster.instance(inyerface, instance);
    }
}
