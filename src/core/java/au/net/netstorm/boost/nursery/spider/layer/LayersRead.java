package au.net.netstorm.boost.nursery.spider.layer;

import au.net.netstorm.boost.nursery.proxy.LayerSpec;
import au.net.netstorm.boost.util.type.Implementation;

public interface LayersRead {
    LayerSpec get(Implementation impl);

    boolean exists(Implementation impl);
}
