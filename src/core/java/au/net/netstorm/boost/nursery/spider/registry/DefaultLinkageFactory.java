package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public class DefaultLinkageFactory implements LinkageFactory {
    public Linkage nu(Interface iface) {
        return nu(null, iface, null);
    }

    public Linkage nu(Implementation host, Interface iface) {
        return nu(host, iface, null);
    }

    public Linkage nu(Implementation host, Interface iface, String name) {
        return new DefaultLinkage(host, iface, name);
    }
}
