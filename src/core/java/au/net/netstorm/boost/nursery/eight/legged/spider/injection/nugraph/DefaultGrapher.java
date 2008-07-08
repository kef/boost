package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultGrapher implements Grapher {
    private final SiteWalker walker = new DefaultSiteWalker();
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();
    private FactoryResolver resolver;

    public DefaultGrapher(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    // FIX BREADCRUMB 2394 ccccccccccc implementing GraphWrapper
    public <T> T graph(InjectionType<T> type) {
        Graph graph = new DefaultGraph(resolver);
        InjectionSite site = builder.build(type);
        return graph(type, site, graph);
    }

    public <T> T graph(InjectionType<T> type, Provider provider) {
        Graph graph = new DefaultGraph(resolver);
        InjectionSite site = builder.build(type);
        graph.add(site, provider);
        return graph(type, site, graph);
    }

    private <T> T graph(InjectionType<T> type, InjectionSite site, Graph graph) {
        Object instance = graph(site, graph);
        Class<T> cls = type.rawClass();
        return cls.cast(instance);
    }

    private Object graph(InjectionSite site, Graph graph) {
        walker.traverse(graph, site);
        lifecycle(graph);
        return graph.resolve(site);
    }

    private void lifecycle(Graph graph) {
        graph.instantiate();
        graph.wire();
        graph.post();
    }
}
