package au.net.netstorm.boost.spider.onion.core;

import java.lang.reflect.Method;

// FIX 2248 Same as Closure.
public interface Layer {
    Object invoke(Method method, Object[] parameters);
}
