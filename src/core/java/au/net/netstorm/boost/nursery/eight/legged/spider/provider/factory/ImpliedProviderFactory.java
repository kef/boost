package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.core.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.guts.InjectionSite;

// FIX 2328 just giving some concepts a name and trying to map them to existing functionality
public final class ImpliedProviderFactory implements ProviderFactory {
    public Provider nu(InjectionSite site) {
        // FIX 2328 link to implicit factory
        return null;
    }

    public boolean canHandle(InjectionSite site) {
        throw new UnsupportedOperationException();
    }
}
