package au.net.netstorm.boost.nursery.spider.layer;

import au.net.netstorm.boost.nursery.proxy.ProxySpec;
import au.net.netstorm.boost.util.type.Implementation;

public interface ProxiesRead {
    ProxySpec get(Implementation impl);

    boolean exists(Implementation impl);
}
