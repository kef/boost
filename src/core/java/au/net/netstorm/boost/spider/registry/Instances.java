package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;

public interface Instances {
    void put(Interface iface, Implementation impl, ResolvedInstance instance);

    ResolvedInstance get(Interface iface, Implementation impl);

    boolean exists(Interface iface, Implementation impl);
}
