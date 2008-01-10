package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.nursery.spider.registry.Linkage;
import au.net.netstorm.boost.nursery.spider.registry.WrongRegistrationException;
import au.net.netstorm.boost.spider.flavour.DefaultNiceMap;
import au.net.netstorm.boost.spider.flavour.NiceMap;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultBlueprints implements Blueprints {
    private final NiceMap map = new DefaultNiceMap();
    private final TypeMaster typer = new DefaultTypeMaster();

    // FIX ()   2237 Use host.
    public void put(Linkage linkage, Blueprint blueprint) {
        check(linkage, blueprint);
        map.put(linkage, blueprint);
    }

    // FIX ()   2237 Use host.
    public Blueprint get(Linkage linkage) {
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
