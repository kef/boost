package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.spider.flavour.DefaultNiceMap;
import au.net.netstorm.boost.spider.flavour.NiceMap;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultBlueprints implements Blueprints {
    // FIX () FRED 12345 Move out of nursery.
    private final TypeMaster typer = new DefaultTypeMaster();
    private final NiceMap map = new DefaultNiceMap();

    // FIX ()   2237 Use host.
    public void put(Linkage linkage, Blueprint blueprint) {
        check(linkage, blueprint);
        map.put(linkage, blueprint);
    }

    // FIX ()   2237 Use host.
    public Blueprint get(Linkage linkage) {
        // 1. Get most specific.
        // 2. Get with name(*).
        // 3. Get with host(*), name(*).
        return (Blueprint) map.get(linkage);
    }

    // FIX ()   2237 Use host??????  Check callers.
    public boolean exists(Linkage linkage) {
        return map.exists(linkage);
    }

    private void check(Linkage linkage, Blueprint blueprint) {
        Interface iface = linkage.getIface();
        Implementation impl = blueprint.getImplementation();
        if (!typer.implementz(impl, iface)) throw new WrongRegistrationException(impl, linkage);
    }
}
