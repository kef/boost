package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistry implements Registry {
    private final RegistryEngine registryEngine;
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;

    public DefaultRegistry(RegistryEngine spinnerEngine) {
        this.registryEngine = spinnerEngine;
    }

    public void multiple(Class iface, Class impl) {
        multiple(iface, impl, UNFLAVOURED);
    }

    public void multiple(Class iface, Class impl, Flavour flavour) {
        Interface inyerface = new DefaultInterface(iface);
        Implementation implementation = new DefaultImplementation(impl);
        registryEngine.multiple(inyerface, implementation, flavour);
    }

    public void instance(Class iface, Object ref) {
        Interface inyerface = new DefaultInterface(iface);
        ResolvedInstance instance = new DefaultBaseReference(ref);
        registryEngine.instance(inyerface, instance, UNFLAVOURED);
    }
}
