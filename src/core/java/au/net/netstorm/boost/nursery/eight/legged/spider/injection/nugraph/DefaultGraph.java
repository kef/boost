package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.LazyProviderCreator;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.gunge.collection.DefaultIntegrityMap;
import au.net.netstorm.boost.gunge.collection.Creator;

// FIX 2394 use or lose. building parrallel implementation for better graph builder.
public final class DefaultGraph implements Graph {
    private final IntegrityMap<InjectionSite, Provider> providers = new DefaultIntegrityMap<InjectionSite, Provider>();
    private final FactoryResolver resolver;


    public DefaultGraph(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    public Provider provide(InjectionSite site) {
        Creator<InjectionSite, Provider> creator = new LazyProviderCreator(resolver);
        return providers.getOrCreate(site, creator);
    }

    public void instantiate() {
        // FIX BREADCRUMB 2394 aaaaaaaaaaaa create an instance for each required provider   
        // FIX 2394 depenencies specify a partial ordering, real ordering is arbitrary
    }
}
