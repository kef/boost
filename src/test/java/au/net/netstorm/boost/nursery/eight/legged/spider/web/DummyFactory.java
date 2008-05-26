package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DummyFactory implements Factory {
    public Provider nu(InjectionSite site) { return null; }
    public boolean canHandle(InjectionSite site) { return false; }
}
