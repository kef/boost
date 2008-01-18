package au.net.netstorm.boost.spider.onion.layer.scrunch;

import au.net.netstorm.boost.edge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Closure;

public final class DefaultScrunchClosure implements ScrunchClosure {
    private final Closure next;
    private boolean scrunched;

    public DefaultScrunchClosure(Closure next) {
        this.next = next;
    }

    public Object invoke(Method method, Object[] args) {
        if (scrunched) throw new ScrunchException();
        return next.invoke(method, args);
    }

    public void scrunch() {
        scrunched = true;
    }
}
