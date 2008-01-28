package au.net.netstorm.boost.nursery.spider.layer;

import au.net.netstorm.boost.nursery.proxy.Layers;
import au.net.netstorm.boost.spider.flavour.DefaultStrictMap;
import au.net.netstorm.boost.spider.flavour.StrictMap;
import au.net.netstorm.boost.util.type.Implementation;

public final class DefaultProxies implements Proxies {
    private final StrictMap<Implementation, Layers> map = new DefaultStrictMap<Implementation, Layers>();

    public Layers get(Implementation impl) {
        return map.get(impl);
    }

    public boolean exists(Implementation impl) {
        return map.exists(impl);
    }

    public void put(Implementation impl, Layers spec) {
        map.put(impl, spec);
    }
}
