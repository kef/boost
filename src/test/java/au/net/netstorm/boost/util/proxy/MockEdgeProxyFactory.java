package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;

import au.net.netstorm.boost.reflect.EdgeProxyFactory;
import au.net.netstorm.boost.util.exception.NotImplementedException;
import junit.framework.Assert;

final class MockEdgeProxyFactory extends Assert implements EdgeProxyFactory {
    public Object getProxy(ClassLoader loader, Class[] types, InvocationHandler invocationHandler) {
        throw new NotImplementedException();
    }
}
