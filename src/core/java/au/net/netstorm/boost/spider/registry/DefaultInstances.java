package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.InterfaceMap;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultInstances implements Instances {
    private final InterfaceMap map;

    public DefaultInstances(InterfaceMap map) {
        this.map = map;
    }

    public void put(Interface iface, ResolvedInstance instance) {
        check(iface, instance);
        map.put(iface, instance);
    }

    public ResolvedInstance get(Interface iface) {
        return (ResolvedInstance) map.get(iface);
    }

    public boolean exists(Interface iface) {
        return map.exists(iface);
    }

    private void check(Interface iface, ResolvedInstance instance) {
        Object ref = instance.getRef();
        Class type = iface.getType();
        Class cls = ref.getClass();
        if (type.isAssignableFrom(cls)) return;
        throw new WrongRegistrationTypeException(iface);
    }
}