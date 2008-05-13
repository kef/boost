package au.net.netstorm.boost.nursery.compose;

import au.net.netstorm.boost.gunge.exception.NotImplementedException;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;
import junit.framework.Assert;

public final class MockLayer extends Assert implements Layer {
    private boolean called;

    public Object invoke(Method method, Object[] args) {
        throw new NotImplementedException();
    }

    public void init() {
        called = false;
    }
}
