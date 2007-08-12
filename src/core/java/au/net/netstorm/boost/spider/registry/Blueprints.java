package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Interface;

public interface Blueprints {
    void put(Interface iface, Flavour flavour, Blueprint blueprint);

    Blueprint get(Interface iface, Flavour flavour);

    boolean exists(Interface iface, Flavour flavour);
}