package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public interface AutoEdge<T> extends InvocationHandler, Edge<T> {
    Object invoke(Object proxy, Method method, Object[] args);
}
