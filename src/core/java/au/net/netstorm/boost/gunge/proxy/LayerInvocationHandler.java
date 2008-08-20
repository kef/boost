package au.net.netstorm.boost.gunge.proxy;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.nursery.proxy.DefaultMethod;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.spider.onion.core.Layered;

final class LayerInvocationHandler extends Primordial implements Layered, InvocationHandler {
    private final Layer layer;

    public LayerInvocationHandler(Layer layer) {
        this.layer = layer;
    }

    public Layer layer() {
        return layer;
    }

    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
        Method edgeMethod = new DefaultMethod(method);
        return layer.invoke(edgeMethod, args);
    }
}
