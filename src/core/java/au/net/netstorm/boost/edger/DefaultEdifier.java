package au.net.netstorm.boost.edger;

import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeProxy;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeProxy;

import java.lang.reflect.InvocationHandler;

public final class DefaultEdifier implements Edgifier {
    private final EdgeProxy edgeProxy = new DefaultEdgeProxy();
    private final ProxyFactory proxyFactory = new DefaultProxyFactory(edgeProxy);

    public Object edgifyFactory(Class factoryType, Class producedType) {
        Interface type = new DefaultInterface(factoryType);
        InvocationHandler handler = new EdgifierInvocationHandler();
        return proxyFactory.newProxy(type, handler);
    }
}
