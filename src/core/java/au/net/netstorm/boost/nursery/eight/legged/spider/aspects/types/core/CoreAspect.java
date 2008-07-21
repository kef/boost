package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.types.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspect;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

public final class CoreAspect implements Aspect {
    private final Object core;

    public CoreAspect(Object core) {
        this.core = core;
    }

    public Object invoke(Method method, Object[] args) {
        return method.invoke(core, args);
    }
}
