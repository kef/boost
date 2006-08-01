package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public final class DefaultEdgeProxy implements EdgeProxy {
    public Object getProxy(ClassLoader loader, Class[] types, InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(loader, types, invocationHandler);
    }
}
