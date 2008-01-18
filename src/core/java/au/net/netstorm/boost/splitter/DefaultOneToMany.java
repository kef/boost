package au.net.netstorm.boost.splitter;

import au.net.netstorm.boost.spider.onion.core.Closure;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class DefaultOneToMany implements OneToMany, Closure {
    private final ProxyFactory proxyFactory = new DefaultProxyFactory();
    private final List many = new ArrayList();
    private final Interface type;

    public DefaultOneToMany(Interface type) {
        noNulls(type);
        this.type = type;
    }

    public synchronized void add(Object oneOfMany) {
        noNulls(oneOfMany);
        many.add(oneOfMany);
    }

    public synchronized Object getOne() {
        return proxyFactory.newProxy(type, this);
    }

    public synchronized Object invoke(Object proxyRef, Method method, Object[] parameters) throws Throwable {
        Object[] listeners = many.toArray(new Object[]{});
        invoke(listeners, method, parameters);
        return null;
    }

    private void invoke(Object[] listeners, Method method, Object[] parameters) throws Throwable {
        for (int i = 0; i < listeners.length; i++) {
            invoke(method, listeners, i, parameters);
        }
    }

    private void invoke(Method method, Object[] listeners, int i, Object[] parameters) throws Throwable {
        try {
            method.invoke(listeners[i], parameters);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    private void noNulls(Object ref) {
        if (ref == null) {
            throw new IllegalArgumentException();
        }
    }
}
