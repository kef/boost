package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.DefaultNiceMap;
import au.net.netstorm.boost.spider.flavour.NiceMap;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

import java.util.ArrayList;
import java.util.List;

public final class DefaultInstances implements Instances {
    private final NiceMap map = new DefaultNiceMap();

    public synchronized void put(Interface iface, Implementation impl, ResolvedInstance instance) {
        check(impl, instance);
        List key = getKey(iface, impl);
        map.put(key, instance);
    }

    public synchronized ResolvedInstance get(Interface iface, Implementation impl) {
        List key = getKey(iface, impl);
        return (ResolvedInstance) map.get(key);
    }

    public synchronized boolean exists(Interface iface, Implementation impl) {
        List key = getKey(iface, impl);
        return map.exists(key);
    }

    // FIX ()   2237 Do this a better way.
    private List getKey(Interface iface, Implementation impl) {
        List list = new ArrayList();
        list.add(iface);
        list.add(impl);
        return list;
    }

    private void check(Implementation impl, ResolvedInstance instance) {
        Class type = impl.getImpl();
        Object ref = instance.getRef();
        Class cls = ref.getClass();
        if (type.isAssignableFrom(cls)) return;
        throw new WrongRegistrationTypeException(impl);
    }
}