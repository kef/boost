package au.net.netstorm.boost;

import java.lang.reflect.Method;

public final class DefaultPassThroughInvocationHandler implements PassThroughInvocationHandler {
    private Object delegate;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

    public void setDelegate(Object delegate) {
        this.delegate = delegate;
    }
}
