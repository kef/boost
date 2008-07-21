package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.aspecter;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspect;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspects;

// FIX 2394 use or lose. wire into bootstrapper.
public final class DefaultAspector implements Aspector {
    private final Aspects aspects;

    public DefaultAspector(Aspects aspects) {
        this.aspects = aspects;
    }

    public void cut(Class iface, Class<? extends Aspect> aspect) {
        aspects.add(iface, aspect);
    }
}
