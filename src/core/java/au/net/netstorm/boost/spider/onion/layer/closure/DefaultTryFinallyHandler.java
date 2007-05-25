package au.net.netstorm.boost.spider.onion.layer.closure;

import java.lang.reflect.Method;

public final class DefaultTryFinallyHandler implements TryFinallyHandler {
    private final TryFinally tryFinally;

    public DefaultTryFinallyHandler(Object delegate, TryFinally tryFinally) {
        // FIX 54976 Use parameters or lose em.
        this.tryFinally = tryFinally;
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        // FIX 54976 Return a non-null.
        tryFinally.in();
        return null;
    }
}
