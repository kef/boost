package au.net.netstorm.boost.nursery.spider.linkage;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.spider.linkage.DefaultLinkageFactory;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;

// FIX ()  2237 Perhaps remove Linkage nulls by making different Linkage objects.
public final class DefaultLinkageWildcard implements LinkageWildcard {
    LinkageFactory linkages = new DefaultLinkageFactory();

    public Linkage name(Linkage linkage) {
        Implementation host = nullGetHost(linkage);
        Interface iface = linkage.getIface();
        return linkages.nu(host, iface, null);
    }

    public Linkage host(Linkage linkage) {
        Interface iface = linkage.getIface();
        String name = nullGetName(linkage);
        return linkages.nu(null, iface, name);
    }

    public Linkage both(Linkage linkage) {
        Interface iface = linkage.getIface();
        return linkages.nu(null, iface, null);
    }

    private Implementation nullGetHost(Linkage linkage) {
        return linkage.hosted() ? linkage.getHost() : null;
    }

    private String nullGetName(Linkage linkage) {
        return linkage.named() ? linkage.getName() : null;
    }
}
