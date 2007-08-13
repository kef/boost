package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.Implementation;

public interface Blueprint extends Data {
    Stamp getStamp();

    Implementation getImplementation();

    Flavour getFlavour();
}
