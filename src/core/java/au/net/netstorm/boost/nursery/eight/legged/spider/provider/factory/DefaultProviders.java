package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import java.util.Set;
import java.util.HashSet;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2328 just giving some concepts a name and trying to map them to existing functionality
public final class DefaultProviders implements Providers {
    private final Set<ProviderFactory> factories = new HashSet<ProviderFactory>();

    public Provider find(InjectionSite site) {
        for (ProviderFactory factory : factories) {
            if (factory.canHandle(site)) return factory.nu(site);
        }
        throw new IllegalArgumentException("Can not provide for injection site: " + site);
    }

    public void add(ProviderFactory factory) {
        // FIX 2328 should be a StrictSet - fail on nulls and dups
        if (factory == null) throw new IllegalArgumentException("Factory can't be null.");
        if (factories.contains(factory)) throw new IllegalArgumentException("Factory already exists.");
        factories.add(factory);
    }
}
