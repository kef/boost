package au.net.netstorm.boost.util.proxy;

import au.net.netstorm.boost.util.exception.NotImplementedException;
import junit.framework.Assert;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class MockInvocationHandler extends Assert implements InvocationHandler {
    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        throw new NotImplementedException();
    }
}
