package au.net.netstorm.boost.spider.onion.layer.scrunch;

import java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;

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
