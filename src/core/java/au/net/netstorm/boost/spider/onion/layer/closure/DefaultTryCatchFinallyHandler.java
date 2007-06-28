package au.net.netstorm.boost.spider.onion.layer.closure;

import java.lang.reflect.Method;

public final class DefaultTryCatchFinallyHandler implements TryFinallyHandler {
    private final Object delegate;
    private final TryCatchFinally trier;

    public DefaultTryCatchFinallyHandler(Object delegate, TryCatchFinally trier) {
        this.delegate = delegate;
        this.trier = trier;
    }

    public Object invoke(Object object, Method method, Object[] parameters) throws Throwable {
        try {
            trier.theCore();
            return method.invoke(delegate, parameters);
        } finally {
            trier.theFinally();
        }
    }
}
