package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.edge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;

public final class CupboardLayer implements Layer {
    private final Object ref;

    public CupboardLayer(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        return method.invoke(ref, args);
    }
}
