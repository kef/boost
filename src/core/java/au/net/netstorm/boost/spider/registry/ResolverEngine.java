package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface ResolverEngine {
    ResolvedInstance resolve(Interface iface, Flavour flavour);

    ResolvedInstance resolve(Implementation impl, Flavour flavour);
}
