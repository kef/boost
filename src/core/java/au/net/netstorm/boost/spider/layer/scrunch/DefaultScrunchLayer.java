package au.net.netstorm.boost.spider.layer.scrunch;

import java.lang.reflect.Method;

public final class DefaultScrunchLayer implements ScrunchLayer {
    private final Object next;

    public DefaultScrunchLayer(Object next) {
        this.next = next;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(next, args);
    }
}
