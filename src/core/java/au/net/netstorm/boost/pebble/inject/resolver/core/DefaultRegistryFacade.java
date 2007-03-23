package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInstance;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1824 Rename.
public final class DefaultRegistryFacade implements RegistryFacade {
    private final RegistryEngine registryEngine;

    public DefaultRegistryFacade(RegistryEngine registryEngine) {
        this.registryEngine = registryEngine;
    }

    public boolean hasImplementation(Class iface) {
        Interface inyerface = new DefaultInterface(iface);
        return registryEngine.hasImplementation(inyerface);
    }

    public boolean hasInstance(Class iface) {
        Interface inyerface = new DefaultInterface(iface);
        return registryEngine.hasInstance(inyerface);
    }

    public Implementation getImplementation(Interface iface) {
        return registryEngine.getImplementation(iface);
    }

    public Instance getInstance(Interface iface) {
        return registryEngine.getInstance(iface);
    }

    public void prototype(Class iface, Class impl) {
        Interface inyerface = new DefaultInterface(iface);
        Implementation implementation = new DefaultImplementation(impl);
        registryEngine.prototype(inyerface, implementation);
    }

    public void instance(Class iface, Object ref) {
        Interface inyerface = new DefaultInterface(iface);
        Instance instance = new DefaultInstance(ref);
        registryEngine.instance(inyerface, instance);
    }
}
