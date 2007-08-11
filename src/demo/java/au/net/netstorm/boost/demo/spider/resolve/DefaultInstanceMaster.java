package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.spider.registry.InstanceMaster;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 2081 Move into core and TDD.

// FIX 2081 Fail if instance does not implement iface.
public final class DefaultInstanceMaster implements InstanceMaster {
    private final FlavouredMap map;

    public DefaultInstanceMaster(FlavouredMap map) {
        this.map = map;
    }

    public void instance(Interface iface, ResolvedInstance instance, Flavour flavour) {
        map.put(iface, flavour, instance);
    }

    public ResolvedInstance getInstance(Interface iface, Flavour flavour) {
        return (ResolvedInstance) map.get(iface, flavour);
    }

    public boolean hasInstance(Interface iface, Flavour flavour) {
        return map.exists(iface, flavour);
    }
}
