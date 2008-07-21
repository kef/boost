package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;

public final class DefaultGrapher implements Grapher {
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();
    private final GraphLifecycleEnforcer enforcer = new DefaultGraphLifecycleEnforcer();
    private final GraphWirer wirer = new DefaultGraphWirer();
    private final FactoryResolver resolver;
    private final AspectResolver aspector;

    public DefaultGrapher(FactoryResolver resolver, AspectResolver aspector) {
        this.resolver = resolver;
        this.aspector = aspector;
    }

    // FIX 2394 can these graph methods be made into one?
    public <T> T graph(InjectionType<T> type, Object... args) {
        InjectionSite site = builder.root(type);
        GraphLifecycle graph = wirer.wire(resolver, aspector, site, args);
        return graph(type, graph);
    }

    public <T> T graph(InjectionType<T> type, Provider provider) {
        InjectionSite site = builder.root(type);
        Graph graph = wirer.wire(resolver, aspector, site, provider);
        return graph(type, graph);
    }

    private <T> T graph(InjectionType<T> type, GraphLifecycle graph) {
        Object instance = enforcer.apply(graph);
        Class<T> cls = type.rawClass();
        return cls.cast(instance);
    }
}
