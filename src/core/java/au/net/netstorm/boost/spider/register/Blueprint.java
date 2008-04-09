package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.LooseData;
import au.net.netstorm.boost.gunge.type.NullIntolerant;

// FIX ()   2237 This should contain the interface.
public interface Blueprint extends LooseData, NullIntolerant {
    Stamp getStamp();

    Implementation getImplementation();

    Object[] getParameters();
}
