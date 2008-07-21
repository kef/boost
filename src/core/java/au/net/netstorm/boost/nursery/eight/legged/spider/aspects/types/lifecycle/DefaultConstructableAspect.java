package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.types.lifecycle;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspect;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Cut;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.core.Constructable;

// FIX 2394 use or lose. spiking lifecycle as aspect.
public final class DefaultConstructableAspect implements ConstructableAspect {
    private final Aspect delegate;
    private final Constructable core;
    private volatile boolean constructed = false;

    public DefaultConstructableAspect(Cut cut, Aspect delegate) {
        this.delegate = delegate;
        this.core = core(cut);
    }

    public Object invoke(Method method, Object[] args) {
        if (!constructed) construct();
        return delegate.invoke(method, args);
    }

    private Constructable core(Cut cut) {
        Object core = cut.core();
        if (!(core instanceof Constructable)) return fail();
        return (Constructable) core;
    }

    private synchronized void construct() {
        core.constructor();
    }

    private Constructable fail() {
        throw new IllegalArgumentException("Core object is not constructable.");
    }
}
