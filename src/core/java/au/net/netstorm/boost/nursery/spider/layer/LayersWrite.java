package au.net.netstorm.boost.nursery.spider.layer;

import au.net.netstorm.boost.nursery.proxy.LayerSpec;
import au.net.netstorm.boost.util.type.Implementation;

public interface LayersWrite {
    void put(Implementation impl, LayerSpec spec);
}
