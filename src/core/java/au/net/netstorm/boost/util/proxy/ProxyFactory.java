package au.net.netstorm.boost.util.proxy;

import au.net.netstorm.boost.util.type.Interface;

import java.lang.reflect.InvocationHandler;

public interface ProxyFactory {
    Object newProxy(Interface type, InvocationHandler handler);
}
