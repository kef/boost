package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface StampedResolvedInstance extends Data {
    ResolvedInstance getInstance();

    Stamp getStamp();
}
