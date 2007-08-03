package au.net.netstorm.boost.nursery.spider.onion.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class OnionHandler implements InvocationHandler {
    private final Object real;

    public OnionHandler(Object real) {
        this.real = real;
    }

    // FIX 1887 Complete this.
    public Object invoke(Object ref, Method method, Object[] params) throws Throwable {
        return method.invoke(real, params);
    }
}
