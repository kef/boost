package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 just giving some concepts a name and trying to map them to existing functionality
public final class ImpliedFactory implements Factory {
    public Provider nu(InjectionSite site) {
        // FIX 2394 link to implicit factory
        return null;
    }

    public boolean canHandle(InjectionSite site) {
        throw new UnsupportedOperationException();
    }
}
