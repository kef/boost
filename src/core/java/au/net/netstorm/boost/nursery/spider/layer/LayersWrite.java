package au.net.netstorm.boost.nursery.spider.layer;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.nursery.proxy.LayerSpec;

public interface LayersWrite {
    void put(Implementation impl, LayerSpec spec);
}
