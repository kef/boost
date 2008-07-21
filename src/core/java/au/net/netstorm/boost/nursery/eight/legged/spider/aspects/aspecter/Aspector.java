package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.aspecter;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspect;

// FIX 2394 use or lose. expose like binder.
public interface Aspector {
    // FIX 2394 Strong type engine. Make this a Nice api.
    void cut(Class iface, Aspect aspect);
    void cut(Class iface, Class<? extends Aspect> aspect);
    // FIX 2394 cut on method?
}
