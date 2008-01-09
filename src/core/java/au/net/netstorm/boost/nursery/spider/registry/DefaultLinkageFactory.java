package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public class DefaultLinkageFactory implements LinkageFactory {
    public Linkage nu(Interface iface) {
        return new DefaultLinkage(null, iface, null);
    }

    public Linkage nu(Implementation host, Interface iface) {
        throw new UnsupportedOperationException();
    }

    public Linkage nu(Implementation host, Interface iface, String name) {
        throw new UnsupportedOperationException();
    }
}
