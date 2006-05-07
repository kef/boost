package au.net.netstorm.boost.split;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import au.net.netstorm.boost.java.lang.reflect.DefaultEdgeProxyFactory;
import au.net.netstorm.boost.java.lang.reflect.EdgeProxyFactory;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

// FIXME: SC521 Is "split" the best name we can come up with?  "multiplex" sucks.

public final class DefaultOneToMany implements OneToMany, InvocationHandler {
    private final Interface type;
    private final List many = new ArrayList();
    private final ProxyFactory proxyFactory = buildFactory();

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
        if (ref == null) throw new IllegalArgumentException();
    }

    // FIXME: SC521 This is not tested.  It never really was.  It has been flushed out in SC521.
    private ProxyFactory buildFactory() {
        // FIXME: SC521 This is an interesting example of a wirer.  External parties only want to use a DOTM.
        EdgeProxyFactory edge = new DefaultEdgeProxyFactory();
        return new DefaultProxyFactory(edge);
    }
}
