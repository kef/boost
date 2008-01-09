package au.net.netstorm.boost.nursery.spider.onion.ring;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;

import java.lang.reflect.Method;

public final class InnerRing implements Ring {
    private static final EdgeMethod METHODER = new DefaultEdgeMethod();
    private final Object real;

    public InnerRing(Object real) {
        this.real = real;
    }

    public Object call(Method method, Object[] params) {
        return METHODER.invoke(method, real, params);
    }
}
