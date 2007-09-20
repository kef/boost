package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.util.type.Interface;

public interface InterfaceMap {
    void put(Interface iface, Object thing);

    Object get(Interface iface);

    boolean exists(Interface iface);
}
