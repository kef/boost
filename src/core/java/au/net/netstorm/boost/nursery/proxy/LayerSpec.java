package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.spider.onion.core.Layer;

public interface LayerSpec extends Data {
    Class<? extends Layer>[] getLayers();
}
