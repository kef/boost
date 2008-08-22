package au.net.netstorm.boost.sniper.random;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// FIX 2130 Convert to layer.
final class ObjectInvocationHandler implements InvocationHandler {
    private final Object o;

    public ObjectInvocationHandler(Object o) {
        this.o = o;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(o, args);
    }
}
