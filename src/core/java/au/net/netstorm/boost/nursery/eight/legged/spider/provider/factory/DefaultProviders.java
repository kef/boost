package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

import java.util.HashSet;
import java.util.Set;

// FIX 2394 just giving some concepts a name and trying to map them to existing functionality
public final class DefaultProviders implements Providers {
    private final Set<ProviderFactory> factories = new HashSet<ProviderFactory>();

    public Provider find(InjectionSite site) {
        for (ProviderFactory factory : factories) {
            if (factory.canHandle(site)) return factory.nu(site);
        }
        throw new IllegalArgumentException("Can not provide for injection site: " + site);
    }

    public void add(ProviderFactory factory) {
        // FIX 2394 should be a StrictSet - fail on nulls and dups
        if (factory == null) throw new IllegalArgumentException("Factory can't be null.");
        if (factories.contains(factory)) throw new IllegalArgumentException("Factory already exists.");
        factories.add(factory);
    }
}
