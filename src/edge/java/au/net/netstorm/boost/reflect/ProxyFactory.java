package au.net.netstorm.boost.reflect;

import java.lang.reflect.InvocationHandler;

// FIXME: SC521 Rename to EdgeProxyFactory.

public interface ProxyFactory {
    Object getProxy(ClassLoader loader, Class[] types, InvocationHandler invocationHandler);
}
