package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.nursery.spider.linkage.DefaultLinkageWidener;
import au.net.netstorm.boost.nursery.spider.linkage.LinkageWidener;
import au.net.netstorm.boost.spider.flavour.DefaultNiceMap;
import au.net.netstorm.boost.spider.flavour.NiceMap;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX 94156 Remove dupe with DefaultBlueprints

// OK LineLength {
public final class DefaultProxies implements Proxies {
    private static final Linkage NO_LINKAGE = null;
    private final NiceMap<Linkage, Class<? extends Layer>[]> map = new DefaultNiceMap<Linkage, Class<? extends Layer>[]>();
    private final LinkageWidener widener = new DefaultLinkageWidener();

    public void put(Linkage linkage, Class<? extends Layer>[] layer) {
        map.put(linkage, layer);
    }

    public Class<? extends Layer>[] get(Linkage linkage) {
        Linkage link = nullGet(linkage);
        if (link == NO_LINKAGE) throw new IllegalStateException();
        return map.get(link);
    }

    public boolean exists(Linkage linkage) {
        Linkage link = nullGet(linkage);
        return (link != NO_LINKAGE);
    }

    private Linkage nullGet(Linkage linkage) {
        Linkage[] linkages = widener.widen(linkage);
        for (Linkage link : linkages) {
            if (map.exists(link)) return link;
        }
        return NO_LINKAGE;
    }
}
// } OK LineLength