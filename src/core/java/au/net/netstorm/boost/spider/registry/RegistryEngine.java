package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 2081 Add instance(Interface iface, Implementation implementation, Flavour flavour).
public interface RegistryEngine {
    void multiple(Interface iface, Implementation implementation, Flavour flavour);

    void instance(Interface iface, ResolvedInstance instance, Flavour flavour);
}
