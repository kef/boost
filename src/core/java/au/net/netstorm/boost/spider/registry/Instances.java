package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Instances {
    void put(Implementation iface, ResolvedInstance instance);

    ResolvedInstance get(Implementation impl);

    boolean exists(Implementation impl);
}
