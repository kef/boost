package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.DefaultNiceMap;
import au.net.netstorm.boost.spider.flavour.NiceMap;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultInstances implements Instances {
    private final NiceMap map = new DefaultNiceMap();

    public synchronized void put(Implementation key, ResolvedInstance instance) {
        check(key, instance);
        map.put(key, instance);
    }

    public synchronized ResolvedInstance get(Implementation key) {
        return (ResolvedInstance) map.get(key);
    }

    public synchronized boolean exists(Implementation key) {
        return map.exists(key);
    }

    private void check(Implementation impl, ResolvedInstance instance) {
        Class type = impl.getImpl();
        Object ref = instance.getRef();
        Class cls = ref.getClass();
        if (type.isAssignableFrom(cls)) return;
        throw new WrongRegistrationTypeException(impl);
    }
}