package au.net.netstorm.boost.sledge.java.lang.reflect;

import java.lang.reflect.InvocationHandler;

public interface ProxySupplier {
    Object getProxy(ClassLoader loader, Class[] types, InvocationHandler invocationHandler);
}
