package au.net.netstorm.boost.nursery.eight.legged.spider.factory.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class ProviderFactory extends Primordial implements Factory {
    private final Provider provider;

    public ProviderFactory(Provider provider) {
        this.provider = provider;
    }

    public Provider nu(InjectionSite site) {
        return provider;
    }

    // FIX 2394 make this method optional, does not make sense for most keyed rules
    public boolean canHandle(InjectionSite site) {
        return true;
    }
}
