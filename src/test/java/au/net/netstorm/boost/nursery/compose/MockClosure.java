package au.net.netstorm.boost.nursery.compose;

import au.net.netstorm.boost.spider.onion.core.Closure;
import au.net.netstorm.boost.util.exception.NotImplementedException;
import junit.framework.Assert;

import java.lang.reflect.Method;

// SUGGEST Nearly the same as MockClosure in util.proxy package.
final class MockClosure extends Assert implements Closure {
    private boolean called;

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        throw new NotImplementedException();
    }

    public void init() {
        called = false;
    }
}
