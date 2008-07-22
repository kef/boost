package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.optional.Optional;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.DefaultInstantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultProvidersWirer implements ProvidersWirer {
    private final Argumentor argumentor = new DefaultArgumentor();
    private final Instantiator instantiator = new DefaultInstantiator();
    private final FactoryResolver resolver;

    public DefaultProvidersWirer(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    public Providers nu(Instances instances, Optional<Provider> provider, InjectionSite root, Object[] args) {
        Providers providers = providers(provider, root);
        boot(providers, root, instances, args);
        return providers;
    }

    private Providers providers(Optional<Provider> provider, InjectionSite root) {
        Creator<InjectionSite, Provider> creator = new LazyProviderCreator(resolver);
        Providers providers = new DefaultProviders(creator);
        if (provider.isSet()) put(providers, provider, root);
        return providers;
    }

    // FIX 2394 This could be an operation on Providers.
    private void put(Providers providers, Optional<Provider> optional, InjectionSite root) {
        Provider provider = optional.get();
        providers.put(root, provider);
    }

    private void boot(Providers providers, InjectionSite root, Instances instances, Object[] args) {
        Provider provider = providers.provide(root);
        argumentor.providers(providers, provider, root, args);
        instantiator.instantiate(providers, instances, root, args);
    }

}
