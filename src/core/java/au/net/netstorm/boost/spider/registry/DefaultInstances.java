package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.DefaultNiceMap;
import au.net.netstorm.boost.spider.flavour.NiceMap;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultInstances implements Instances {
    private final NiceMap map = new DefaultNiceMap();

    public synchronized void put(Interface iface, ResolvedInstance instance) {
        check(iface, instance);
        map.put(iface, instance);
    }

    public synchronized ResolvedInstance get(Interface iface) {
        return (ResolvedInstance) map.get(iface);
    }

    public synchronized boolean exists(Interface iface) {
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