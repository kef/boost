package au.net.netstorm.boost.gunge.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.gunge.exception.NotImplementedException;
import junit.framework.Assert;

final class MockInvocationHandler extends Assert implements InvocationHandler {
    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        throw new NotImplementedException();
    }
}
