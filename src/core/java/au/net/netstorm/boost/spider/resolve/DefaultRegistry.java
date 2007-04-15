package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistry implements Registry {
    private final RegistryMaster registryMaster;

    public DefaultRegistry(RegistryMaster registryMaster) {
        this.registryMaster = registryMaster;
    }

    public void prototype(Class iface, Class impl) {
        Interface inyerface = new DefaultInterface(iface);
        Implementation implementation = new DefaultImplementation(impl);
        registryMaster.implementation(inyerface, implementation);
    }

    public void instance(Class iface, Object ref) {
        Interface inyerface = new DefaultInterface(iface);
        ResolvedInstance instance = new DefaultBaseReference(ref);
        registryMaster.instance(inyerface, instance);
    }
}
