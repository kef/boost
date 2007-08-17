package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Interface;

public interface Greenprints {
    Blueprint get(Interface iface, Flavour flavour);

    boolean exists(Interface iface, Flavour flavour);
}
