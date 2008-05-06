package au.net.netstorm.boost.spider.instance;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.gunge.type.UnresolvedInstance;

public interface PartialInstances {
    void clear();

    boolean exists(Implementation impl);

    ResolvedInstance get(Implementation impl);

    void put(Implementation impl, UnresolvedInstance ref);

    void remove(Implementation impl);
}
