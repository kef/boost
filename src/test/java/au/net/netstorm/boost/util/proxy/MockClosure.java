package au.net.netstorm.boost.util.proxy;

import au.net.netstorm.boost.spider.onion.core.Closure;
import au.net.netstorm.boost.util.exception.NotImplementedException;
import junit.framework.Assert;

import java.lang.reflect.Method;

final class MockClosure extends Assert implements Closure {
    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        throw new NotImplementedException();
    }
}
