package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.nursery.spider.linkage.DefaultLinkageWidener;
import au.net.netstorm.boost.nursery.spider.linkage.LinkageWidener;
import au.net.netstorm.boost.spider.flavour.DefaultNiceMap;
import au.net.netstorm.boost.spider.flavour.NiceMap;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

// FIX 2237 Move out of nursery.
public final class DefaultBlueprints implements Blueprints {
    private static final Linkage NO_LINKAGE = null;
    private final TypeMaster typer = new DefaultTypeMaster();
    private final NiceMap<Linkage, Blueprint> map = new DefaultNiceMap<Linkage, Blueprint>();
    private final LinkageWidener widener = new DefaultLinkageWidener();

    public void put(Linkage linkage, Blueprint blueprint) {
        check(linkage, blueprint);
        map.put(linkage, blueprint);
    }

    public boolean exists(Linkage linkage) {
        Linkage link = nullGet(linkage);
        return (link != NO_LINKAGE);
    }

    public Blueprint get(Linkage linkage) {
        Linkage link = nullGet(linkage);
        if (link == NO_LINKAGE) throw new IllegalStateException();
        return map.get(link);
    }

    private Linkage nullGet(Linkage linkage) {
        Linkage[] links = widener.widen(linkage);
        for (Linkage link : links) {
            if (map.exists(link)) return link;
        }
        return NO_LINKAGE;
    }

    private void check(Linkage linkage, Blueprint blueprint) {
        Interface iface = linkage.getIface();
        Implementation impl = blueprint.getImplementation();
        if (!typer.implementz(impl, iface)) throw new WrongRegistrationException(impl, linkage);
    }
}
