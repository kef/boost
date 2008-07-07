package au.net.netstorm.boost.nursery.eight.legged.spider.factory.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 MAG Expecting a fix here.  Where does this tie in.
// FIX 2394 MAG Complete.

public final class SingletonFactory implements Factory {
    // FIX 2394 Reinstate (if needed).
//    public SingletonFactory(Factory factory) {
//    }

    public Provider nu(InjectionSite site) {
        throw new UnsupportedOperationException();
    }

    public boolean canHandle(InjectionSite site) {
        throw new UnsupportedOperationException();
    }
}
