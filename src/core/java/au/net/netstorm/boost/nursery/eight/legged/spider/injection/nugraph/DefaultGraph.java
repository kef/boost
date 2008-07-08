package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

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
    private final FactoryResolver resolver;

    // FIX BREADCRUMB 2394 ccccccccc wrap graph in nice wrapper that holds the factory resolver for use in GraphBuilder
    public DefaultGraph(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    public Provider provide(InjectionSite site) {
        Creator<InjectionSite, Provider> creator = new LazyProviderCreator(resolver);
        return providers.get(site, creator);
    }

    public void instantiate() {
        // FIX BREADCRUMB 2394 aaaaaaaaaaaa create an instance for each required provider   
        // FIX 2394 depenencies specify a partial ordering, real ordering is arbitrary
        for (InjectionSite site : providers.keySet()) {
            // FIX 2394 use or lose.
            Provider provider = providers.get(site);
            // FIX BREADCRUMB 2394 aaaaaaaaaa create an instance and store in instances
        }
    }
}
