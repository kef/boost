package au.net.netstorm.boost.nursery.spider.layer;

import au.net.netstorm.boost.nursery.proxy.ProxySpec;
import au.net.netstorm.boost.spider.flavour.DefaultNiceMap;
import au.net.netstorm.boost.spider.flavour.NiceMap;
import au.net.netstorm.boost.util.type.Implementation;

public final class DefaultProxies implements Proxies {
    private final NiceMap<Implementation, ProxySpec> map = new DefaultNiceMap<Implementation, ProxySpec>();

    public ProxySpec get(Implementation impl) {
        return map.get(impl);
    }

    public boolean exists(Implementation impl) {
        return map.exists(impl);
    }

    public void put(Implementation impl, ProxySpec spec) {
        map.put(impl, spec);
    }
}
