package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.DefaultInstantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.gunge.collection.Creator;

// FIX 2394 use or lose. wire into StatefulGraphWirer.
public final class DefaultProvidersWirer implements ProvidersWirer {
    private final Argumentor argumentor = new DefaultArgumentor();
    private final Instantiator instantiator = new DefaultInstantiator();
    private final FactoryResolver resolver;

    public DefaultProvidersWirer(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    public Providers wire(Instances instances, Provider provider, InjectionSite root, Object[] args) {
        Creator<InjectionSite, Provider> creator = new LazyProviderCreator(resolver);
        Providers providers = providers(provider, root, creator);
        boot(providers, root, instances, args);
        return providers;
    }

    private Providers providers(Provider provider, InjectionSite root, Creator<InjectionSite, Provider> creator) {
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

}
