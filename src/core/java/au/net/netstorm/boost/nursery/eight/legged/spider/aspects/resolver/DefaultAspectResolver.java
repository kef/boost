package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspect;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspects;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.AspectType;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.DefaultAspectType;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.types.core.CoreAspect;

// FIX 2394 Use or lose. Wire into PostProcessor.
public final class DefaultAspectResolver implements AspectResolver {
    private final Aspects aspects;

    public DefaultAspectResolver(Aspects aspects) {
        this.aspects = aspects;
    }

    public AspectType resolve(Object o) {
        Class cls = o.getClass();
        Class[] ifaces = cls.getInterfaces();
        Aspect core = new CoreAspect(o);
        Class<? extends Aspect>[] layers = getLayers(ifaces);
        return new DefaultAspectType(ifaces, core, layers);
    }

    private Class<? extends Aspect>[] getLayers(Class[] ifaces) {
        List<Class<? extends Aspect>> aspects = new ArrayList<Class<? extends Aspect>>();
        for (Class iface : ifaces) add(aspects, iface);
        return toArray(aspects);
    }

    private void add(List<Class<? extends Aspect>> accumulated, Class iface) {
        Class[] layers = aspects.get(iface);
        List list = Arrays.asList(layers);
        accumulated.addAll(list);
    }

    private Class<? extends Aspect>[] toArray(List<Class<? extends Aspect>> aspects) {
        return aspects.toArray(new Class[aspects.size()]);
    }
}
