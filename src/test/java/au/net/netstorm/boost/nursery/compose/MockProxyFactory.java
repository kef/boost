package au.net.netstorm.boost.nursery.compose;

import java.lang.reflect.InvocationHandler;

import au.net.netstorm.boost.util.exception.NotImplementedException;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.Assert;

final class MockProxyFactory extends Assert implements ProxyFactory {
    public Object newProxy(Interface type, InvocationHandler handler) {
        throw new NotImplementedException();
    }
}
