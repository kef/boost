package au.net.netstorm.boost.reflect;

import java.lang.reflect.InvocationHandler;

public interface ProxyFactory {
    Object getProxy(ClassLoader loader, Class[] types, InvocationHandler invocationHandler);
}
