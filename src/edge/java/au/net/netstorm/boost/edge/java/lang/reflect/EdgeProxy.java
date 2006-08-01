package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.InvocationHandler;

public interface EdgeProxy {
    Object getProxy(ClassLoader loader, Class[] types, InvocationHandler invocationHandler);
}
