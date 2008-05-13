package au.net.netstorm.boost.spider.onion.layer.passthrough;

import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

public final class DefaultPassThroughLayer implements PassThroughLayer {
    private Object delegate;

    public Object invoke(Method method, Object[] args) {
        return method.invoke(delegate, args);
    }

    public void setDelegate(Object delegate) {
        this.delegate = delegate;
    }
}
