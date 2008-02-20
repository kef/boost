package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.DefaultStrictMap;
import au.net.netstorm.boost.spider.flavour.StrictMap;
import au.net.netstorm.boost.spider.linkage.DefaultLinkageWidener;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageWidener;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultBlueprints implements Blueprints {
    private static final Linkage NO_LINKAGE = null;
    private final TypeMaster typer = new DefaultTypeMaster();
    private final StrictMap<Linkage, Blueprint> map = new DefaultStrictMap<Linkage, Blueprint>();
    private final LinkageWidener widener = new DefaultLinkageWidener();

    public void put(Linkage linkage, Blueprint blueprint) {
        check(linkage, blueprint);
        map.put(linkage, blueprint);
    }

    public Blueprint get(Linkage linkage) {
        Linkage link = nullGetLinkage(linkage);
        if (link == NO_LINKAGE) throw new IllegalStateException();
        return map.get(link);
    }

    public boolean exists(Linkage linkage) {
        Linkage link = nullGetLinkage(linkage);
        return (link != NO_LINKAGE);
    }

    private Linkage nullGetLinkage(Linkage linkage) {
        Linkage[] linkages = widener.widen(linkage);
        for (Linkage link : linkages) {
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
