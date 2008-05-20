package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.core.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.guts.InjectionSite;

// FIX 2328 just giving some concepts a name and trying to map them to existing functionality
public final class DefaultProviderFactory implements ProviderFactory {
    private final PartialProviderFactory[] providers;

    public DefaultProviderFactory(PartialProviderFactory[] providers) {
        this.providers = providers;
    }

    public Provider nu(InjectionSite site) {
        for (PartialProviderFactory p : providers) {
            if (p.canHandle(site)) return p.nu(site);
        }
        throw new IllegalArgumentException("Can not provide for injection site: " + site);
    }
}
