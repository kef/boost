package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Instances {
    void put(Interface iface, ResolvedInstance instance);

    ResolvedInstance get(Interface iface);

    boolean exists(Interface iface);
}
