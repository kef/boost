package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

// FIX 2394 use or lose. building up aspect code.
public interface Aspect {
    Object invoke(Method method, Object[] args);
}
