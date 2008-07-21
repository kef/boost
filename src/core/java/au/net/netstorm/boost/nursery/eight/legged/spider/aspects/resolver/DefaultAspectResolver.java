package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspects;

// FIX 2394 Use or lose. Wire into PostProcessor.
public final class DefaultAspectResolver implements AspectResolver {
    private final Aspects aspects;

    public DefaultAspectResolver(Aspects aspects) {
        this.aspects = aspects;
    }

    // FIX 2394 Object resolve(Object o)
    // FIX BREADCRUMB 2394 building up resolution.
    Object resolve(Object o) {
//        Class cls = o.getClass();
//        Class[] ifaces = cls.getInterfaces();
//        for (Class iface : ifaces) {
//            iface
//        }
        return o;
    }
}
