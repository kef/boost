package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInstance;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRegistry implements Registry {
    private final RegistryMaster registryMaster;

    public DefaultRegistry(RegistryMaster registryMaster) {
        this.registryMaster = registryMaster;
    }

    public void prototype(Class iface, Class impl) {
        Interface inyerface = new DefaultInterface(iface);
        Implementation implementation = new DefaultImplementation(impl);
        registryMaster.prototype(inyerface, implementation);
    }

    public void instance(Class iface, Object ref) {
        Interface inyerface = new DefaultInterface(iface);
        Instance instance = new DefaultInstance(ref);
        registryMaster.instance(inyerface, instance);
    }
}
