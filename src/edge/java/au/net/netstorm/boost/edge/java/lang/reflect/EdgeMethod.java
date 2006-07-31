package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Method;

public interface EdgeMethod {
    Object invoke(Method method, Object obj, Object[] args);
}
