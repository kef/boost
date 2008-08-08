package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.gunge.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.gunge.proxy.ProxyFactory;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.types.core.CoreAspect;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.spider.onion.core.Layer;

public final class DefaultAspectorizer implements Aspectorizer {
    private final ProxyFactory proxier = new DefaultProxyFactory();
    private final InjectionTypeBuilder typer = new DefaultInjectionTypeBuilder();
    private final InjectionSiteBuilder siter = new DefaultInjectionSiteBuilder();
    private final AspectResolver resolver;

    public DefaultAspectorizer(AspectResolver resolver) {
        this.resolver = resolver;
    }

    public Object aspectorize(Providers providers, Object target) {
        AspectSpec spec = resolver.resolve(target);
        return spec.hasLayers() ? aspect(providers, target, spec) : target;
    }

    // FIX BREADCRUMB 2394 aaaaaaaaaaa implement me.
    private Object aspect(Providers providers, Object target, AspectSpec spec) {
        Cut cut = new DefaultCut(target);
        Interface[] ifaces = spec.interfaces();
        Object result = core(cut, ifaces, target);
        for (Class<? extends Layer> layer : spec.layers()) {
            result = layer(providers, cut, ifaces, layer);
        }
        return result;
    }

    private Object core(Cut cut, Interface[] ifaces, Object result) {
        Layer layer = new CoreAspect(result);
        return build(cut, ifaces, layer);
    }

    // FIX 2394 There is a lean nuer to be split out here.
    private Object layer(Providers providers, Cut cut, Interface[] ifaces, Class<? extends Layer> type) {
        InjectionType<? extends Layer> injection = typer.build(type);
        InjectionSite site = siter.root(injection);
        Provider provider = providers.provide(site);
        Layer delegate = cut.outer();
        // FIX 2394 There is no wiring done of layer, should it be injected?
        // FIX 2394   YES!!! what was I thinking.
        Layer layer = (Layer) provider.nu(cut, delegate);
        return build(cut, ifaces, layer);
    }

    private Object build(Cut cut, Interface[] ifaces, Layer layer) {
        Object replacement = proxier.newProxy(ifaces, layer);
        cut.add(layer);
        return replacement;
    }
}
