package au.net.netstorm.boost.splitter;

import au.net.netstorm.boost.edge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Closure;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

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

    public synchronized Object invoke(Method method, Object[] args) {
        Object[] listeners = many.toArray(new Object[]{});
        invoke(listeners, method, args);
        return null;
    }

    private void invoke(Object[] listeners, Method method, Object[] parameters) {
        for (Object listener : listeners) {
            method.invoke(listener, parameters);
        }
    }

    private void noNulls(Object ref) {
        if (ref == null) {
            throw new IllegalArgumentException();
        }
    }
}
