package au.net.netstorm.boost.nursery.eight.legged.spider.factory.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class SingletonFactory implements Factory {
    public SingletonFactory(Factory factory) {
    }

    public Provider nu(InjectionSite site) {
        throw new UnsupportedOperationException();
    }

    public boolean canHandle(InjectionSite site) {
        throw new UnsupportedOperationException();
    }
}
