package au.net.netstorm.boost.demo.spider.instance;

import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public interface PartialInstances {
    void clear();

    boolean exists(Interface iface);

    ResolvedInstance get(Interface iface);

    void put(Interface iface, UnresolvedInstance ref);

    void remove(Interface iface);
}
