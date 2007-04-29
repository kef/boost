package au.net.netstorm.boost.spider.onion.layer.passthrough;

import java.lang.reflect.Method;

public final class DefaultOldPassThroughLayer implements OldPassThroughLayer {
    private Object delegate;

    public Object invoke(Object proxy, Method method, Object[] parameters) throws Throwable {
        return method.invoke(delegate, parameters);
    }

    public void setDelegate(Object delegate) {
        this.delegate = delegate;
    }
}
