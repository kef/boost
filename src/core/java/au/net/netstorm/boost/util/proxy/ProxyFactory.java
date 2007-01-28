package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.util.type.Interface;

public interface ProxyFactory {
    Object newProxy(Interface type, InvocationHandler handler);
}
