package au.net.netstorm.boost.nursery.spider.layer;

import au.net.netstorm.boost.nursery.proxy.Layers;
import au.net.netstorm.boost.util.type.Implementation;

public interface ProxiesRead {
    Layers get(Implementation impl);

    boolean exists(Implementation impl);
}
