package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Instances {
    ResolvedInstance getInstance(Interface iface, Flavour flavour);

    boolean hasInstance(Interface iface, Flavour flavour);
}
