package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Instances {
    // FIX 2081 reorg sig (iface, flavour, instance)
    void put(Interface iface, Flavour flavour, ResolvedInstance instance);

    ResolvedInstance get(Interface iface, Flavour flavour);

    boolean exists(Interface iface, Flavour flavour);
}
