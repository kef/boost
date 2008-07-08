package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultGrapher implements Grapher {
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();
    private final GraphLifecycleEnforcer enforcer = new DefaultGraphLifecycleEnforcer();
    private final GraphWirer wirer = new DefaultGraphWirer();
    private FactoryResolver resolver;

    public DefaultGrapher(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    public <T> T graph(InjectionType<T> type, Object... args) {
        InjectionSite site = builder.root(type);
        GraphLifecycle graph = wirer.wire(resolver, site, args);
        return graph(type, graph);
    }

    public <T> T graph(InjectionType<T> type, Provider provider, Object... args) {
        InjectionSite site = builder.root(type);
        Graph graph = wirer.wire(resolver, site, args);
        graph.add(site, provider);
        return graph(type, graph);
    }

    private <T> T graph(InjectionType<T> type, GraphLifecycle graph) {
        Object instance = enforcer.apply(graph);
        Class<T> cls = type.rawClass();
        return cls.cast(instance);
    }
}
