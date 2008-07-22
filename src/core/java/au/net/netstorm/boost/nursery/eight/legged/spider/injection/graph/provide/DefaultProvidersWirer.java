package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.optional.Optional;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ParameterizedProvider;

public final class DefaultProvidersWirer implements ProvidersWirer {
    private final FactoryResolver resolver;

    public DefaultProvidersWirer(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    public Providers nu(Instances instances, Optional<Provider> provider, InjectionSite root, Object[] args) {
        Providers providers = providers(provider, root);
        applyArgs(providers, root, args);
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

    private void applyArgs(Providers providers, InjectionSite root, Object[] args) {
        if (args.length == 0) return;
        Provider provider = providers.provide(root);
        Provider parameterized = new ParameterizedProvider(provider, args);
        providers.replace(root, parameterized);
    }
}
