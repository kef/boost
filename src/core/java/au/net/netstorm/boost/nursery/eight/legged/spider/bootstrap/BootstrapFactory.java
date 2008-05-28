package au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 implement me for those few special startup cases
public final class BootstrapFactory implements Factory {
    public Provider nu(InjectionSite site) {
        return null;
    }

    public boolean canHandle(InjectionSite site) {
        return false;
    }
}
