package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface BlueprintsWrite {
    void put(Implementation host, Interface iface, Blueprint blueprint);
}
