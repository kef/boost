package au.net.netstorm.boost.nursery.eight.legged.spider.factory.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

// FIX 2394 just giving some concepts a name and trying to map them to existing functionality
public final class DefaultProviders implements Providers {
    private final Factories factories;

    public DefaultProviders(Factories factories) {
        this.factories = factories;
    }

    public Provider find(InjectionSite site) {
        Factory factory = factories.find(site);
        return factory.nu(site);
    }
}
