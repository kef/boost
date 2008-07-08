package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultGrapher implements Grapher {
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();
    private FactoryResolver resolver;

    public DefaultGrapher(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    // FIX BREADCRUMB 2394 ccccccccccc implementing GraphWrapper
    public <T> T graph(InjectionType<T> type) {
        InjectionSite site = builder.build(type);
        Graph graph = new DefaultGraph(resolver, site);
        return graph(type, graph);
    }

    public <T> T graph(InjectionType<T> type, Provider provider) {
        InjectionSite site = builder.build(type);
        Graph graph = new DefaultGraph(resolver, site);
        graph.add(site, provider);
        return graph(type, graph);
    }

    private <T> T graph(InjectionType<T> type, Graph graph) {
        Object instance = graph(graph);
        Class<T> cls = type.rawClass();
        return cls.cast(instance);
    }

    private Object graph(Graph graph) {
        lifecycle(graph);
        return graph.resolve();
    }

    private void lifecycle(Graph graph) {
        graph.build();
        graph.instantiate();
        graph.wire();
        graph.post();
    }
}
