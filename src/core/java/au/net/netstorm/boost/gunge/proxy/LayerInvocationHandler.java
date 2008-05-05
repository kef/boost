package au.net.netstorm.boost.gunge.proxy;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.bullet.primmm.Primordial;
import au.net.netstorm.boost.edge.java.lang.reflect.Method;
import au.net.netstorm.boost.nursery.proxy.DefaultMethod;
import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX 2248 TDD.
final class LayerInvocationHandler extends Primordial implements InvocationHandler {
    private final Layer layer;

    public LayerInvocationHandler(Layer layer) {
        this.layer = layer;
    }

    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
        Method edgeMethod = new DefaultMethod(method);
        return layer.invoke(edgeMethod, args);
    }
}
