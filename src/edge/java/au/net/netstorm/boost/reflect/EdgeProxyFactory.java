package au.net.netstorm.boost.reflect;

import java.lang.reflect.InvocationHandler;

// FIXME: SC521 The actual ProxyFactory should take an Interface[] or Interface as a type argument.
// FIXME: SC521 Rename to EdgeProxyFactory.

public interface EdgeProxyFactory {
    Object getProxy(ClassLoader loader, Class[] types, InvocationHandler invocationHandler);
}
