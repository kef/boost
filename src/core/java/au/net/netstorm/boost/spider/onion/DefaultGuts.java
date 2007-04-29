package au.net.netstorm.boost.spider.onion;

import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;

public final class DefaultGuts implements Guts {
    private final EdgeMethod methoder = new DefaultEdgeMethod();
    private final Object ref;

    public DefaultGuts(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] parameters) {
        return methoder.invoke(method, ref, parameters);
    }
}
