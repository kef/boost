package au.net.netstorm.boost.spider.onion.layer.closure;

import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

public final class DefaultTryFinallyLayer implements TryFinallyLayer {
    private final TryFinally trier;
    private final Object delegate;

    public DefaultTryFinallyLayer(Object delegate, TryFinally trier) {
        this.delegate = delegate;
        this.trier = trier;
    }

    public Object invoke(Method method, Object[] args) {
        try {
            trier.theCore();
            return method.invoke(delegate, args);
        } finally {
            trier.theFinally();
        }
    }
}
