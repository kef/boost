package au.net.netstorm.boost.nursery.compose;

import au.net.netstorm.boost.edge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Closure;
import au.net.netstorm.boost.util.exception.NotImplementedException;
import junit.framework.Assert;

public final class MockClosure extends Assert implements Closure {
    private boolean called;

    public Object invoke(Method method, Object[] args) {
        throw new NotImplementedException();
    }

    public void init() {
        called = false;
    }
}
