package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class MockFactory extends Primordial implements Factory {
    int dummyfield = 1;
    public Provider nu(InjectionSite site) {
        throw new UnsupportedOperationException();
    }

    public boolean canHandle(InjectionSite site) {
        throw new UnsupportedOperationException();
    }
}
