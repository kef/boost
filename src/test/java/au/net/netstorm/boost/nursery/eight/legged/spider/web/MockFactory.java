package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import junit.framework.AssertionFailedError;

public class MockFactory implements Factory {
    public Provider nu(InjectionSite site) {
        throw new AssertionFailedError();
    }

    public boolean canHandle(InjectionSite site) {
        throw new AssertionFailedError();
    }
}
