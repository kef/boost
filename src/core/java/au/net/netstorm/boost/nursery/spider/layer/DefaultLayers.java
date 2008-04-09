package au.net.netstorm.boost.nursery.spider.layer;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.nursery.proxy.LayerSpec;
import au.net.netstorm.boost.spider.flavour.DefaultStrictMap;
import au.net.netstorm.boost.spider.flavour.StrictMap;

public final class DefaultLayers implements Layers {
    private final StrictMap<Implementation, LayerSpec> map = new DefaultStrictMap<Implementation, LayerSpec>();

    public LayerSpec get(Implementation impl) {
        return map.get(impl);
    }

    public boolean exists(Implementation impl) {
        return map.exists(impl);
    }

    public void put(Implementation impl, LayerSpec spec) {
        map.put(impl, spec);
    }
}
