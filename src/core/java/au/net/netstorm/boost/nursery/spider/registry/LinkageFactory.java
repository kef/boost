package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface LinkageFactory {
    Linkage nu(Interface iface);

    Linkage nu(Implementation host, Interface iface);

    Linkage nu(Implementation host, Interface iface, String name);
}
