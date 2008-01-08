package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.LooseData;
import au.net.netstorm.boost.util.type.NullIntolerant;

public interface Blueprint extends LooseData, NullIntolerant {
    Stamp getStamp();

    Implementation getImplementation();

    Object[] getParameters();
}
