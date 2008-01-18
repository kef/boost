package au.net.netstorm.boost.spider.onion.core;

import au.net.netstorm.boost.edge.java.lang.reflect.Method;

public interface Closure {
    Object invoke(Method method, Object[] args);
}
