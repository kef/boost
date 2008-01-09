package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.LooseData;
import au.net.netstorm.boost.util.type.NullIntolerant;

// FIX ()   2237 This should contain the interface.
public interface Blueprint extends LooseData, NullIntolerant {
    Stamp getStamp();

    Implementation getImplementation();

    Object[] getParameters();
}
