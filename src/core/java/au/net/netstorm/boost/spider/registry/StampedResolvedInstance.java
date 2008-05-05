package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;

// FIX 2215 Get rid of this transitional item.

// FIX 2215 Either ResolvedInstance gets a Stamp, or we go a completely different direction in Factories.
public interface StampedResolvedInstance extends Data {
    ResolvedInstance getInstance();

    Stamp getStamp();
}
