package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.core.Provider;

// FIX 2328 just giving some concepts a name and trying to map them to existing functionality
public interface ProviderFactory {
    Provider nu(InjectionSite site);
    boolean canHandle(InjectionSite site);
}
