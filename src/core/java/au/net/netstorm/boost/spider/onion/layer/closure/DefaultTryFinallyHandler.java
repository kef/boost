package au.net.netstorm.boost.spider.onion.layer.closure;

import java.lang.reflect.Method;

public final class DefaultTryFinallyHandler implements TryFinallyHandler {
    public DefaultTryFinallyHandler(Object delegate, TryFinally tryfinally) {
        // FIX 54976 Use parameters or lose em.
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        // FIX 54976 Return a non-null.
        return null;
    }
}
