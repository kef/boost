package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.util.type.Interface;

// FIX 2237 Stitch this in. 
public interface FlavouredMap {
    void put(Interface iface, Flavour flavour, Object thing);

    Object get(Interface iface, Flavour flavour);

    boolean exists(Interface iface, Flavour flavour);
}
