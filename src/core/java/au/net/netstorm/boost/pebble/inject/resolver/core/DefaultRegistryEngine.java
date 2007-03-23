package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInstance;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRegistryEngine implements RegistryEngine {
    private final RegistryFinder registryFinder;

    public DefaultRegistryEngine(RegistryFinder registryFinder) {
        this.registryFinder = registryFinder;
    }

    public boolean hasImplementation(Class iface) {
        Interface inyerface = new DefaultInterface(iface);
        return registryFinder.hasImplementation(inyerface);
    }

    public boolean hasInstance(Class iface) {
        Interface inyerface = new DefaultInterface(iface);
        return registryFinder.hasInstance(inyerface);
    }

    public Implementation getImplementation(Interface iface) {
        return registryFinder.getImplementation(iface);
    }

    public Instance getInstance(Interface iface) {
        return registryFinder.getInstance(iface);
    }

    public void prototype(Class iface, Class impl) {
        Interface inyerface = new DefaultInterface(iface);
        Implementation implementation = new DefaultImplementation(impl);
        registryFinder.prototype(inyerface, implementation);
    }

    public void instance(Class iface, Object ref) {
        Interface inyerface = new DefaultInterface(iface);
        Instance instance = new DefaultInstance(ref);
        registryFinder.instance(inyerface, instance);
    }
}
