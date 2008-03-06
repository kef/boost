package au.net.netstorm.boost.spider.register;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.nursery.spider.register.DefaultInstanceOfChecker;
import au.net.netstorm.boost.spider.flavour.DefaultStrictMap;
import au.net.netstorm.boost.spider.flavour.StrictMap;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultInstances implements Instances {
    private final InstanceOfChecker checker = new DefaultInstanceOfChecker();
    private final StrictMap map = new DefaultStrictMap();

    public synchronized void put(Interface iface, Implementation impl, ResolvedInstance instance) {
        checker.instanceOf(instance, impl);
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

    private List getKey(Interface iface, Implementation impl) {
        List tuple = new ArrayList();
        tuple.add(iface);
        tuple.add(impl);
        return tuple;
    }
}