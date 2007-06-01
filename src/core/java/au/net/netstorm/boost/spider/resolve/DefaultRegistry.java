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
    // FIX 1977 No nulls.  Transitional.
    private static final Flavour DODGY = null;

    public DefaultRegistry(RegistryEngine spinnerEngine) {
        this.registryEngine = spinnerEngine;
    }

    public void multiple(Class iface, Class impl) {
        Interface inyerface = new DefaultInterface(iface);
        Implementation implementation = new DefaultImplementation(impl);
        // FIX BREADCRUMB 1977 EEEEEEEEEEEEEEEEEEEEEEEEEEE Drive up "global" flavour on the interface.
        registryEngine.multiple(inyerface, implementation, DODGY);
    }

    public void instance(Class iface, Object ref) {
        Interface inyerface = new DefaultInterface(iface);
        ResolvedInstance instance = new DefaultBaseReference(ref);
        registryEngine.instance(inyerface, instance, DODGY);
    }
}
