package au.net.netstorm.boost.nursery.pebble.onion;

import java.lang.reflect.Method;

public final class DefaultPassThroughInvocationHandler implements PassThroughInvocationHandler {
    private Object delegate;

    public Object invoke(Object proxy, Method method, Object[] parameters) throws Throwable {
        return method.invoke(delegate, parameters);
    }

    public void setDelegate(Object delegate) {
        this.delegate = delegate;
    }
}
