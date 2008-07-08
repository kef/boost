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
        Graph graph = graph();
        InjectionSite site = walk(graph, Hello.class);
        lifecycle(graph);
        checkResolveHello(graph, site);
    }

    private void checkResolveHello(Graph graph, InjectionSite site) {
        Object instance = graph.resolve(site);
        assertEquals(true, instance instanceof DefaultHello);
        DefaultHello hello = (DefaultHello) instance;
        World world = hello.world;
        assertNotNull(world);
    }

    private void lifecycle(Graph graph) {
        graph.instantiate();
        graph.wire();
        graph.post();
    }

    private Graph graph() {
        FactoryResolver resolver = resolver();
        return new DefaultGraph(resolver);
    }

    private InjectionSite walk(Graph graph, Class<Hello> cls) {
        SiteWalker walker = new DefaultSiteWalker();
        InjectionSite site = site(cls);
        walker.traverse(graph, site);
        return site;
    }

    private FactoryResolver resolver() {
        Bindings bindings = spider.resolve(Bindings.class);
        Factories factories = spider.resolve(Factories.class);
        return new DefaultFactoryResolver(bindings, factories);
    }

    private InjectionSite site(Class cls) {
        InjectionType type = builder.build(cls);
        return new RootInjectionSite(type);
    }
}
