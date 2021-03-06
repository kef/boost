package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.AspectSpec;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspects;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.DefaultAspectSpec;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.gunge.type.InterfaceMaster;
import au.net.netstorm.boost.gunge.type.DefaultInterfaceMaster;
import au.net.netstorm.boost.gunge.type.Interface;

public final class DefaultAspectResolver implements AspectResolver {
    private final InterfaceMaster ifacer = new DefaultInterfaceMaster();
    private final Aspects aspects;

    public DefaultAspectResolver(Aspects aspects) {
        this.aspects = aspects;
    }

    public AspectSpec resolve(Object ref) {
        Class cls = ref.getClass();
        Class[] ifaces = cls.getInterfaces();
        Interface[] interfaces = ifacer.interfaces(ifaces);
        Class<? extends Layer>[] layers = getLayers(ifaces);
        return new DefaultAspectSpec(interfaces, layers);
    }

    private Class<? extends Layer>[] getLayers(Class[] ifaces) {
        List<Class<? extends Layer>> aspects = new ArrayList<Class<? extends Layer>>();
        for (Class iface : ifaces) add(aspects, iface);
        return toArray(aspects);
    }

    private void add(List<Class<? extends Layer>> accumulated, Class iface) {
        Class[] layers = aspects.get(iface);
        List list = Arrays.asList(layers);
        accumulated.addAll(list);
    }

    private Class<? extends Layer>[] toArray(List<Class<? extends Layer>> aspects) {
        return aspects.toArray(new Class[aspects.size()]);
    }
}
