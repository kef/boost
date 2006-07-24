package au.net.netstorm.boost.java.lang.reflect;

import java.lang.reflect.Method;

public interface EdgeMethod {
    EdgeMethod EDGE_METHOD = new DefaultEdgeMethod();

    Object invoke(Method method, Object obj, Object[] args);
}
