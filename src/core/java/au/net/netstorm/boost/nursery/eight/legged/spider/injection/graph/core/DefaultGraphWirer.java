package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspectorizer;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.DefaultAspectorizer;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.DefaultInstances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.DefaultInstantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.DefaultPostProcessor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.PostProcessor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultProviders;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultSiteWalker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.LazyProviderCreator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.SiteWalker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.DefaultResolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire.DefaultWirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire.Wirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 fix this mess.
// OK ClassDataAbstractionCoupling {
public final class DefaultGraphWirer implements GraphWirer {
    private final Instantiator instantiator = new DefaultInstantiator();
    private final Wirer wirer = new DefaultWirer();
    private final PostProcessor poster;
    private final FactoryResolver resolver;

    public DefaultGraphWirer(FactoryResolver resolver, AspectResolver aspector) {
        this.resolver = resolver;
        poster = nu(aspector);
    }

    public Graph wire(InjectionSite root, Object... args) {
        Providers providers = providers();
        return graph(root, providers, args);
    }

    public Graph wire(InjectionSite root, Provider base) {
        Providers providers = providers();
        providers.put(root, base);
        return graph(root, providers);
    }

    private Providers providers() {
        Creator<InjectionSite, Provider> creator = new LazyProviderCreator(resolver);
        return new DefaultProviders(creator);
    }

    private Graph graph(InjectionSite root, Providers providers, Object... args) {
        Instances instances = new DefaultInstances();
        Resolvables resolvables = new DefaultResolvables();
        SiteWalker walker = new DefaultSiteWalker(providers, resolvables);
        Graph graph = new DefaultGraph(walker, instantiator, wirer, poster, providers, instances, resolvables, root);
        return args.length == 0 ? graph : new ParameterizedGraph(graph, providers, instances, root, args);
    }

    private PostProcessor nu(AspectResolver poster) {
        Aspectorizer aspectorizer = new DefaultAspectorizer(poster);
        return new DefaultPostProcessor(aspectorizer);
    }
}
// } OK ClassDataAbstractionCoupling