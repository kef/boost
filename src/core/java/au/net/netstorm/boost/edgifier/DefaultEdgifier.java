package au.net.netstorm.boost.edgifier;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultEdgifier implements Edgifier {
    private final ProxySupplier proxySupplier = new DefaultProxySupplier();
    private final ProxyFactory proxyFactory = new DefaultProxyFactory(proxySupplier);

    public Object edgifyFactory(Class factoryType, Class producedType) {
        Interface type = new DefaultInterface(factoryType);
        InvocationHandler handler = new EdgifierFactoryInvocationHandler(producedType);
        return proxyFactory.newProxy(type, handler);
    }
}
