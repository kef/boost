package au.net.netstorm.boost.spider.layer.core;

import java.lang.reflect.Method;

public interface Layer {
    Object invoke(Method method, Object[] parameters);
}
