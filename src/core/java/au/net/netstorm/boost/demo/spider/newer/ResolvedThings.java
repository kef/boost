package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public interface ResolvedThings {
    void clear();

    boolean exists(Implementation impl);

    ResolvedInstance get(Implementation impl);

    void put(Implementation impl, UnresolvedInstance ref);

    void remove(Implementation impl);
}
