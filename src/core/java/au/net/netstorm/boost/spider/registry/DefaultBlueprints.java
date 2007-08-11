package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultBlueprints implements Blueprints {
    private TypeMaster typer = new DefaultTypeMaster();
    private final FlavouredMap map;

    public DefaultBlueprints(FlavouredMap map) {
        this.map = map;
    }

    public void put(Interface iface, Flavour flavour, Blueprint blueprint) {
        check(iface, blueprint);
        map.put(iface, flavour, blueprint);
    }

    public Blueprint get(Interface iface, Flavour flavour) {
        return (Blueprint) map.get(iface, flavour);
    }

    public boolean exists(Interface iface, Flavour flavour) {
        return map.exists(iface, flavour);
    }

    private void check(Interface iface, Blueprint blueprint) {
        Implementation impl = blueprint.getImplementation();
        if (!typer.implementz(impl, iface)) throw new WrongInterfaceRegistrationException(impl, iface);
    }
}
