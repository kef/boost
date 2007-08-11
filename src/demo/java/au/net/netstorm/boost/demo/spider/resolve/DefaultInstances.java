package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 2081 Move into core and TDD.

// FIX 2081 Fail if instance does not implement iface.
public final class DefaultInstances implements Instances {
    private final FlavouredMap map;

    public DefaultInstances(FlavouredMap map) {
        this.map = map;
    }

    public void put(Interface iface, Flavour flavour, ResolvedInstance instance) {
        map.put(iface, flavour, instance);
    }

    public ResolvedInstance get(Interface iface, Flavour flavour) {
        return (ResolvedInstance) map.get(iface, flavour);
    }

    public boolean exists(Interface iface, Flavour flavour) {
        return map.exists(iface, flavour);
    }
}
