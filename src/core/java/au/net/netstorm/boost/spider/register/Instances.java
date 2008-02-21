package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Instances {
    void put(Interface iface, Implementation impl, ResolvedInstance instance);

    ResolvedInstance get(Interface iface, Implementation impl);

    boolean exists(Interface iface, Implementation impl);
}
