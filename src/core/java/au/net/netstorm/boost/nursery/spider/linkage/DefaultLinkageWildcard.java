package au.net.netstorm.boost.nursery.spider.linkage;

import au.net.netstorm.boost.spider.linkage.DefaultLinkageFactory;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

// FIX ()  2237 Perhaps remove Linkage nulls by making different Linkage objects.
public final class DefaultLinkageWildcard implements LinkageWildcard {
    LinkageFactory linkages = new DefaultLinkageFactory();

    public Linkage name(Linkage linkage) {
        Implementation host = linkage.hosted() ? linkage.getHost() : null;
        Interface iface = linkage.getIface();
        return linkages.nu(host, iface, null);
    }

    public Linkage host(Linkage linkage) {
        Interface iface = linkage.getIface();
        String name = linkage.named() ? linkage.getName() : null;
        return linkages.nu(null, iface, name);
    }

    public Linkage both(Linkage linkage) {
        Interface iface = linkage.getIface();
        return linkages.nu(null, iface, null);
    }
}
