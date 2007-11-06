package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public interface ResolvedThings {
    void clear();

    boolean exists(Interface iface);

    ResolvedInstance get(Interface iface);

    void put(Interface iface, UnresolvedInstance ref);

    void remove(Interface iface);
}
