package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.aspecter;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspect;

public interface Aspector {
    void cut(Class iface, Class<? extends Aspect> aspect);
    // FIX 2394 cut on method?
}
