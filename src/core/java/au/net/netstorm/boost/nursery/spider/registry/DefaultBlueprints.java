package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.nursery.spider.linkage.DefaultLinkageWidener;
import au.net.netstorm.boost.nursery.spider.linkage.Linkage;
import au.net.netstorm.boost.nursery.spider.linkage.LinkageWidener;
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
    private final LinkageWidener widener = new DefaultLinkageWidener();

    // FIX ()   2237 Use host.
    public void put(Linkage linkage, Blueprint blueprint) {
        check(linkage, blueprint);
        map.put(linkage, blueprint);
    }

    // FIX ()   2237 Use host.
    public Blueprint get(Linkage linkage) {
        Linkage widest = widest(linkage);
        // 1. Get most specific.
        // 2. Get with name(*).
        // 3. Get with host(*), name(*).
        return (Blueprint) map.get(widest);
    }

    // FIX ()   2237 Use host??????  Check callers.
    public boolean exists(Linkage linkage) {
        Linkage widest = widest(linkage);
        return map.exists(widest);
    }

    private Linkage widest(Linkage linkage) {
        Linkage[] linkages = widener.widen(linkage);
        return linkages[linkages.length - 1];
    }

    private void check(Linkage linkage, Blueprint blueprint) {
        Interface iface = linkage.getIface();
        Implementation impl = blueprint.getImplementation();
        if (!typer.implementz(impl, iface)) throw new WrongRegistrationException(impl, linkage);
    }
}
