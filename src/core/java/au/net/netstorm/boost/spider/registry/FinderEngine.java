package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface FinderEngine {
    Implementation getImplementation(Interface iface, Flavour flavour);

    ResolvedInstance getInstance(Interface iface, Flavour flavour);

    boolean hasImplementation(Interface iface, Flavour flavour);

    boolean hasInstance(Interface iface, Flavour flavour);
}
