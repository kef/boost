package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX 94156 Split into ProxiesRead and ProxiesWrite?
public interface Proxies {
    void put(Linkage linkage, Class<? extends Layer>[] layers);

    Class<? extends Layer>[] get(Linkage linkage);

    boolean exists(Linkage linkage);
}
