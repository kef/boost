package au.net.netstorm.boost.demo.nuspider.nugraphtemp;

import au.net.netstorm.boost.demo.nuspider.test.NuSpiderDemooooTest;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.DefaultFactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.RootInjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph.Graph;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph.DefaultGraph;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph.SiteWalker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph.DefaultSiteWalker;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

// FIX 2394 delete me when done. using this to drive up new graph implementation.
public final class DefaultGraphMolecularTest extends NuSpiderDemooooTest implements InjectableTest {
    InjectionTypeBuilder builder;

    public void testGraph() {
        Graph graph = nuGraph();
        walkGraph(graph);
        graph.instantiate();
    }

    private void walkGraph(Graph graph) {
        SiteWalker walker = new DefaultSiteWalker();
        InjectionType type = builder.build(Hello.class);
        InjectionSite site = new RootInjectionSite(type);
        walker.traverse(graph, site);
    }

    private Graph nuGraph() {
        Bindings bindings = spider.resolve(Bindings.class);
        Factories factories = spider.resolve(Factories.class);
        FactoryResolver resolver = new DefaultFactoryResolver(bindings, factories);
        return new DefaultGraph(resolver);
    }
}
