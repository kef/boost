package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Closure;

public final class DefaultProxySpec implements ProxySpec {
    private Class<Closure>[] closures;

    public DefaultProxySpec(Class<Closure>... closures) {
        this.closures = closures;
    }

    public Class<Closure>[] get() {
        return closures;
    }
}
