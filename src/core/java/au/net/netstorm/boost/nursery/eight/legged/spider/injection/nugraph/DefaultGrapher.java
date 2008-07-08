package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultGrapher implements Grapher {
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();
    private final GraphLifecycleEnforcer enforcer = new DefaultGraphLifecycleEnforcer();
    private FactoryResolver resolver;

    public DefaultGrapher(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    public <T> T graph(InjectionType<T> type) {
        InjectionSite site = builder.build(type);
        GraphLifecycle graph = new DefaultGraph(resolver, site);
        return graph(type, graph);
    }

    public <T> T graph(InjectionType<T> type, Provider provider) {
        InjectionSite site = builder.build(type);
        Graph graph = new DefaultGraph(resolver, site);
        graph.add(site, provider);
        return graph(type, graph);
    }

    private <T> T graph(InjectionType<T> type, GraphLifecycle graph) {
        Object instance = enforcer.apply(graph);
        Class<T> cls = type.rawClass();
        return cls.cast(instance);
    }
}
