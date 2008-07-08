package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultGrapher implements Grapher {
    private final SiteWalker walker = new DefaultSiteWalker();
    private FactoryResolver resolver;

    public DefaultGrapher(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    // FIX BREADCRUMB 2394 ccccccccccc implementing GraphWrapper
    // FIX 2394 pull up.
    public Object graph(InjectionSite site) {
        Graph graph = new DefaultGraph(resolver);
        return graph(site, graph);
    }

    // FIX 2394 pull up.
    public Object graph(InjectionSite site, Provider provider) {
        Graph graph = new DefaultGraph(resolver);
        graph.add(site, provider);
        return graph(site, graph);
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
