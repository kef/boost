package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.gunge.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.gunge.proxy.ProxyFactory;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.types.core.CoreAspect;
import au.net.netstorm.boost.spider.instantiate.NuImpl;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.spider.resolve.Resolver;

public final class DefaultAspectorizer implements Aspectorizer {
    private final ProxyFactory proxier = new DefaultProxyFactory();
    private final AspectResolver aspects;

    public DefaultAspectorizer(AspectResolver aspects) {
        this.aspects = aspects;
    }

    public Object aspectorize(Resolver resolver, Object target) {
        AspectSpec spec = aspects.resolve(target);
        return spec.hasLayers() ? aspect(resolver, target, spec) : target;
    }

    // FIX BREADCRUMB 2394 aaaaaaaaaaa implement me.
    private Object aspect(Resolver resolver, Object target, AspectSpec spec) {
        Cut cut = new DefaultCut(target);
        Interface[] ifaces = spec.interfaces();
        Object result = core(cut, ifaces, target);
        for (Class<? extends Layer> layer : spec.layers()) {
            result = layer(resolver, cut, ifaces, layer);
        }
        return result;
    }

    private Object core(Cut cut, Interface[] ifaces, Object result) {
        Layer layer = new CoreAspect(result);
        return build(cut, ifaces, layer);
    }

    private Object layer(Resolver resolver, Cut cut, Interface[] ifaces, Class<? extends Layer> type) {
        NuImpl impl = resolver.resolve(NuImpl.class);
        Layer delegate = cut.outer();
        Layer layer = impl.nu(type, cut, delegate);
        return build(cut, ifaces, layer);
    }

    private Object build(Cut cut, Interface[] ifaces, Layer layer) {
        Object replacement = proxier.newProxy(ifaces, layer);
        cut.add(layer);
        return replacement;
    }
}
