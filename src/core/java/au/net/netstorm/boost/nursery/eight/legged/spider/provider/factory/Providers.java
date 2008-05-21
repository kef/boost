package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2328 just giving some concepts a name and trying to map them to existing functionality
public interface Providers {
    Provider find(InjectionSite site);
    void add(ProviderFactory factory);
}
