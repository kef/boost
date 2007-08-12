package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultInstances implements Instances {
    private final FlavouredMap map;

    public DefaultInstances(FlavouredMap map) {
        this.map = map;
    }

    public void put(Interface iface, Flavour flavour, ResolvedInstance instance) {
        check(iface, instance);
        map.put(iface, flavour, instance);
    }

    public ResolvedInstance get(Interface iface, Flavour flavour) {
        return (ResolvedInstance) map.get(iface, flavour);
    }

    public boolean exists(Interface iface, Flavour flavour) {
        return map.exists(iface, flavour);
    }

    private void check(Interface iface, ResolvedInstance instance) {
        Object ref = instance.getRef();
        Class type = iface.getType();
        Class cls = ref.getClass();
        if (type.isAssignableFrom(cls)) return;
        throw new WrongRegistrationTypeException(iface);
    }
}