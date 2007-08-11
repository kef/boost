package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.BlueprintMaster;
import au.net.netstorm.boost.util.type.Interface;

// FIX 2081 Move into core and TDD.

// FIX 2081 Fail if blueprint does not implement iface.
public final class DefaultBlueprintMaster implements BlueprintMaster {
    private final FlavouredMap map;

    public DefaultBlueprintMaster(FlavouredMap map) {
        this.map = map;
    }

    public void blueprint(Interface iface, Blueprint blueprint, Flavour flavour) {
        map.put(iface, flavour, blueprint);
    }

    public Blueprint getBlueprint(Interface iface, Flavour flavour) {
        return (Blueprint) map.get(iface, flavour);
    }

    public boolean hasBlueprint(Interface iface, Flavour flavour) {
        return map.exists(iface, flavour);
    }
}
