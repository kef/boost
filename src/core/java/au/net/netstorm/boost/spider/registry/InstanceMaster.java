package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface InstanceMaster extends Instances {
    // FIX 2081 Either combine all iterfaces or not at all.

    void instance(Interface iface, ResolvedInstance instance, Flavour flavour);
}
