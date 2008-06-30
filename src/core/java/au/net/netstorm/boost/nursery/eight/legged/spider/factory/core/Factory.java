package au.net.netstorm.boost.nursery.eight.legged.spider.factory.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public interface Factory {
    Provider nu(InjectionSite site);
    boolean canHandle(InjectionSite site);
}
