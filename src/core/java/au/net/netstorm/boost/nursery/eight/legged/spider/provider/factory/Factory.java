package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

// FIX 2394 just giving some concepts a name and trying to map them to existing functionality
public interface Factory {
    Provider nu(InjectionSite site);
    boolean canHandle(InjectionSite site);
}
