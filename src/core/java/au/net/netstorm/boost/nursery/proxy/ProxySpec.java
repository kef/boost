package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Closure;

public interface ProxySpec {
    Class<Closure>[] get();
}
