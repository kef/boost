package au.net.netstorm.boost.spider.onion.core;

import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

public interface Layer {
    Object invoke(Method method, Object[] args);
}
