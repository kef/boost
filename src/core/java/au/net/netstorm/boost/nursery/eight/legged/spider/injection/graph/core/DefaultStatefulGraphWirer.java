package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.LazyProviderCreator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultProviders;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Argumentor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultArgumentor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.DefaultInstantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.DefaultInstances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.DefaultResolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.gunge.collection.Creator;

// FIX 2394 split into ProviderWirer.
// DEBT ClassDataAbstractionCoupling {
public final class DefaultStatefulGraphWirer implements StatefulGraphWirer {
    private final Argumentor argumentor = new DefaultArgumentor();
    private final Instantiator instantiator = new DefaultInstantiator();
    private final FactoryResolver resolver;
    private final Graph graph;

    public DefaultStatefulGraphWirer(FactoryResolver resolver, AspectResolver aspector) {
        this.resolver = resolver;
        this.graph = graph(aspector);
    }

    public StatefulGraph wire(InjectionSite root, Provider provider, Object... args) {
        Instances instances = new DefaultInstances();
        Resolvables resolvables = new DefaultResolvables();
        Providers providers = providers(instances, provider, root, args);
        return new DefaultStatefulGraph(graph, providers, instances, resolvables, root);
    }

    private Providers providers(Instances instances, Provider provider, InjectionSite root, Object[] args) {
        Creator<InjectionSite, Provider> creator = new LazyProviderCreator(resolver);
        Providers providers = nuProviders(provider, root, creator);
        boot(providers, root, instances, args);
        return providers;
    }

    private Providers nuProviders(Provider provider, InjectionSite root, Creator<InjectionSite, Provider> creator) {
        Providers providers = new DefaultProviders(creator);
        // FIX 2394 yuck. Optional<Provider>
        if (provider != null) providers.put(root, provider);
        return providers;
    }

    private void boot(Providers providers, InjectionSite root, Instances instances, Object[] args) {
        Provider provider = providers.getOrCreate(root);
        argumentor.providers(providers, provider, root, args);
        instantiator.instantiate(providers, instances, root, args);
    }

    private Graph graph(AspectResolver aspector) {
        GraphWirer wirer = new DefaultGraphWirer(aspector);
        return wirer.wire();
    }
}
// } DEBT ClassDataAbstractionCoupling
