package au.net.netstorm.boost.spider.onion.layer.closure;

import java.lang.reflect.Method;

public final class DefaultTryFinallyHandler implements TryFinallyHandler {
    private final Object delegate;
    private final TryFinally tryFinally;

    public DefaultTryFinallyHandler(Object delegate, TryFinally tryFinally) {
        this.delegate = delegate;
        // FIX 54976 Use parameters or lose em.
        this.tryFinally = tryFinally;
    }

    public Object invoke(Object object, Method method, Object[] parameters) throws Throwable {
        // FIX 54976 try finally.
        tryFinally.in();
        Object result = method.invoke(delegate, parameters);
        tryFinally.out();
        return result;
    }
}
