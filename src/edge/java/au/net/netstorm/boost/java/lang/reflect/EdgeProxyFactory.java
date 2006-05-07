package au.net.netstorm.boost.java.lang.reflect;

import java.lang.reflect.InvocationHandler;

public interface EdgeProxyFactory {
    Object getProxy(ClassLoader loader, Class[] types, InvocationHandler invocationHandler);
}
