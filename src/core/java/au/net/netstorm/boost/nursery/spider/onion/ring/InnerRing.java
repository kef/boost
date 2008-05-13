package au.net.netstorm.boost.nursery.spider.onion.ring;

import java.lang.reflect.Method;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeMethod;

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
