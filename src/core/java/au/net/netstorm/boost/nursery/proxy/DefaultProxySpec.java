package au.net.netstorm.boost.nursery.proxy;

import java.lang.reflect.InvocationHandler;

public final class DefaultProxySpec implements ProxySpec {
    private Class<InvocationHandler>[] closures;

    public DefaultProxySpec(Class<InvocationHandler>... closures) {
        this.closures = closures;
    }

    public Class<InvocationHandler>[] get() {
        return closures;
    }
}
