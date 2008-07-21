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

// DEBT ClassDataAbstractionCoupling {
public final class DefaultGraphWirer implements GraphWirer {
    public Graph wire(FactoryResolver resolver, AspectResolver aspector, InjectionSite root, Object... args) {
        Providers providers = providers(resolver);
        return graph(aspector, root, providers, args);
    }

    public Graph wire(FactoryResolver resolver, AspectResolver aspector, InjectionSite root, Provider base) {
        Providers providers = providers(resolver);
        providers.put(root, base);
        return graph(aspector, root, providers);
    }

    private Providers providers(FactoryResolver resolver) {
        Creator<InjectionSite, Provider> creator = new LazyProviderCreator(resolver);
        return new DefaultProviders(creator);
    }

    private Graph graph(AspectResolver aspector, InjectionSite root, Providers providers, Object... args) {
        Instances instances = new DefaultInstances();
        Aspectorizer aspectorizer = new DefaultAspectorizer(aspector);
        PostProcessor poster = new DefaultPostProcessor(aspectorizer);
        Resolvables resolvables = new DefaultResolvables();
        Instantiator instantiator = new DefaultInstantiator();
        Wirer wirer = new DefaultWirer();
        SiteWalker walker = new DefaultSiteWalker(providers, resolvables);
        Graph graph = new DefaultGraph(providers, instances, poster, root, walker, instantiator, wirer, resolvables);
        return args.length == 0 ? graph : new ParameterizedGraph(graph, providers, instances, root, args);
    }
}
// } DEBT ClassDataAbstractionCoupling