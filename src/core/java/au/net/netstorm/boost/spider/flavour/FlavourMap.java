package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.util.type.Interface;

public interface FlavourMap {
    void put(Interface iface, Flavour flavour, Object thing);

    Object get(Interface iface, Flavour flavour);
}
