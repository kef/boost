package au.net.netstorm.boost.nursery.compose;

import au.net.netstorm.boost.util.exception.NotImplementedException;
import junit.framework.Assert;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// SUGGEST Nearly the same as MockInvocationHandler in util.proxy package.
final class MockInvocationHandler extends Assert implements InvocationHandler {
    private boolean called;

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        throw new NotImplementedException();
    }

    public void init() {
        called = false;
    }
}
