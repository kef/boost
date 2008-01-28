package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.util.type.Data;

public interface LayerSpec extends Data {
    Class<? extends Layer>[] getLayers();
}
