package au.net.netstorm.boost.spider.onion.layer.closure;

import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;

final class CookLayer implements Layer {
    private final Object ref;
    private final Oven oven;

    public CookLayer(Object ref, Oven oven) {
        this.ref = ref;
        this.oven = oven;
    }

    public Object invoke(Method method, Object[] args) {
        oven.on();
        try {
            return method.invoke(ref, args);
        } finally {
            oven.off();
        }
    }
}
