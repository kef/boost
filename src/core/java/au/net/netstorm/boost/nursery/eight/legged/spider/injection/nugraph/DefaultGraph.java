package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import java.util.Set;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.LazyProviderCreator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 use or lose. building parrallel implementation for better graph builder.
public final class DefaultGraph implements Graph {
    private final Providers providers = new DefaultProviders();
    // FIX 2394 use or lose.
    private final Instances instances = new DefaultInstances();
    private final Instantiator instantiator = new DefaultInstantiator();
    private final FactoryResolver resolver;

    // FIX 2394 wrap graph in nice wrapper that holds the factory resolver for use in GraphBuilder
    public DefaultGraph(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    public Provider provide(InjectionSite site) {
        Creator<InjectionSite, Provider> creator = new LazyProviderCreator(resolver);
        return providers.get(site, creator);
    }

    public void instantiate() {
        Set<InjectionSite> sites = providers.keySet();
        instantiator.instantiate(providers, instances, sites);
    }
}
