package au.net.netstorm.boost.spider.onion.layer.scrunch;

import au.net.netstorm.boost.spider.onion.core.Layer;

import java.lang.reflect.Method;

public final class DefaultScrunchLayer implements ScrunchLayer {
    private final Layer next;
    private boolean scrunched;

    public DefaultScrunchLayer(Layer next) {
        this.next = next;
    }

    public Object invoke(Method method, Object[] parameters) {
        if (scrunched) throw new ScrunchException();
        return next.invoke(method, parameters);
    }

    public void scrunch() {
        scrunched = true;
    }
}
