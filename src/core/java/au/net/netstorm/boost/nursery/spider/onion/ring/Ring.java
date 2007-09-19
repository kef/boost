package au.net.netstorm.boost.nursery.spider.onion.ring;

import java.lang.reflect.Method;

public interface Ring {
    Object call(Method method, Object[] params);
}
