package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeProxySupplier;

// FIX 1665 test me
public final class DefaultCreatorProxySupplier implements CreatorProxySupplier {
    private ClassLoader classLoader;
    private EdgeProxySupplier edgeProxySupplier;
    private InvocationHandler invocationHandler;

    public DefaultCreatorProxySupplier(ClassLoader classLoader, InvocationHandler invocationHandler,
            EdgeProxySupplier edgeProxySupplier) {
        this.invocationHandler = invocationHandler;
        this.classLoader = classLoader;
        this.edgeProxySupplier = edgeProxySupplier;
    }

    public Object create(Interface type) {
        return null;
    }
}
