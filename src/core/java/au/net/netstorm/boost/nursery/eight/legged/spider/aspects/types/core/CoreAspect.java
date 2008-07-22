package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.types.core;

import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;

public final class CoreAspect implements Layer {
    private final Object core;

    public CoreAspect(Object core) {
        this.core = core;
    }

    public Object invoke(Method method, Object[] args) {
        return method.invoke(core, args);
    }
}
