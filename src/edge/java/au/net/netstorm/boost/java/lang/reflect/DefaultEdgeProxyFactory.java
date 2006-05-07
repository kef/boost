package au.net.netstorm.boost.java.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public final class DefaultEdgeProxyFactory implements EdgeProxyFactory {
    public Object getProxy(ClassLoader loader, Class[] types, InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(loader, types, invocationHandler);
    }
}
