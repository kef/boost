package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.aspecter;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspect;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspects;
import au.net.netstorm.boost.spider.core.Nu;

// FIX 2394 use or lose. wire into bootstrapper.
public final class DefaultAspector implements Aspector {
    private final Aspects aspects;
    private final Nu nu;

    public DefaultAspector(Aspects aspects, Nu nu) {
        this.aspects = aspects;
        this.nu = nu;
    }

    public void cut(Class iface, Aspect aspect) {
        aspects.add(iface, aspect);
    }

    public void cut(Class iface, Class<? extends Aspect> aspect) {
        Aspect instance = nu.nu(aspect);
        cut(iface, instance);
    }
}
