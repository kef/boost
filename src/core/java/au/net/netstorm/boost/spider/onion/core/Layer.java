package au.net.netstorm.boost.spider.onion.core;

import au.net.netstorm.boost.edge.java.lang.reflect.Method;

public interface Layer {
    Object invoke(Method method, Object[] args);
}
