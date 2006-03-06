package au.net.netstorm.boost.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public final class EdgeProxyFactory implements ProxyFactory {
    public Object getProxy(ClassLoader loader, Class[] types, InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(loader, types, invocationHandler);
    }
}
