package au.net.netstorm.boost.gunge.proxy;

import au.net.netstorm.boost.gunge.type.Interface;

import java.lang.reflect.InvocationHandler;

public interface ProxyFactory {
    Object proxy(InvocationHandler handler, Class[] types);
    Object proxy(InvocationHandler handler, Interface[] types);
}
