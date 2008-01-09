package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.DefaultNiceMap;
import au.net.netstorm.boost.spider.flavour.NiceMap;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

// FIX (Nov 28, 2007) IOC 2215 There feels like a lot of dupe here with DefaultInstances.
public final class DefaultBlueprints implements Blueprints {
    private final NiceMap map = new DefaultNiceMap();
    private final TypeMaster typer = new DefaultTypeMaster();

    // FIX ()   2237 Use host.
    public void put(Implementation host, Interface iface, Blueprint blueprint) {
        check(iface, blueprint);
        map.put(iface, blueprint);
    }

    // FIX ()   2237 Use host.
    public Blueprint get(Implementation host, Interface iface) {
        return (Blueprint) map.get(iface);
    }

    // FIX ()   2237 Use host??????  Check callers.
    public boolean exists(Interface iface) {
        return map.exists(iface);
    }

    private void check(Interface iface, Blueprint blueprint) {
        Implementation impl = blueprint.getImplementation();
        if (!typer.implementz(impl, iface)) throw new WrongInterfaceRegistrationException(impl, iface);
    }
}
