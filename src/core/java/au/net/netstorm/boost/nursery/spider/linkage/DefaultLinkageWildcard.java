package au.net.netstorm.boost.nursery.spider.linkage;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultLinkageWildcard implements LinkageWildcard {
    LinkageFactory linkages = new DefaultLinkageFactory();

    public Linkage name(Linkage linkage) {
        Implementation host = linkage.getHost();
        Interface iface = linkage.getIface();
        return linkages.nu(host, iface);
    }

    public Linkage host(Linkage linkage) {
        throw new UnsupportedOperationException();
    }
}
