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

    public void put(Linkage linkage, Blueprint blueprint) {
        check(linkage, blueprint);
        map.put(linkage, blueprint);
    }

    // FIX ()   2237 Make this neater and faster.
    public Blueprint get(Linkage linkage) {
        Linkage[] linkages = widener.widen(linkage);
        for (Linkage link : linkages) {
            if (map.exists(link)) return (Blueprint) map.get(link);
        }
        throw new IllegalStateException();
    }

    // FIX ()   2237 Make this neater and faster.
    public boolean exists(Linkage linkage) {
        Linkage[] linkages = widener.widen(linkage);
        for (Linkage link : linkages) {
            if (map.exists(link)) return true;
        }
        return false;
    }

    private void check(Linkage linkage, Blueprint blueprint) {
        Interface iface = linkage.getIface();
        Implementation impl = blueprint.getImplementation();
        if (!typer.implementz(impl, iface)) throw new WrongRegistrationException(impl, linkage);
    }
}
