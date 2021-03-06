package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;

final class CupboardLayer implements Layer {
    private final Object ref;

    public CupboardLayer(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        return method.invoke(ref, args);
    }
}
