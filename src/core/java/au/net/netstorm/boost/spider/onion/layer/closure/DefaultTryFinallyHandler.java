package au.net.netstorm.boost.spider.onion.layer.closure;

import java.lang.reflect.Method;

public final class DefaultTryFinallyHandler implements TryFinallyHandler {
    private final Object delegate;
    private final TryFinally tryFinally;

    public DefaultTryFinallyHandler(Object delegate, TryFinally tryFinally) {
        this.delegate = delegate;
        this.tryFinally = tryFinally;
    }

    public Object invoke(Object object, Method method, Object[] parameters) throws Throwable {
        try {
            tryFinally.in();
            return method.invoke(delegate, parameters);
        } finally {
            tryFinally.out();
        }
    }
}
