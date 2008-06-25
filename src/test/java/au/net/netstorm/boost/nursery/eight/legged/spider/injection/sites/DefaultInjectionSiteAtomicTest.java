package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.testdata.DummyHolder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultInjectionSiteAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionSite subject;
    private String name;
    private Class<?> host;
    InjectionType typeMock;
    InjectionSiteChecker checker;

    public void setUpFixtures() {
        name = "x";
        host = DummyHolder.class;
        subject = new DefaultInjectionSite(host, typeMock, name);
    }

    public void testInjectionSite() {
        checker.checkSite(subject, host, typeMock, name);
    }

    public void testInjectionSiteFailure() {
        checkConstructionFailure(null, typeMock, name);
        checkConstructionFailure(host, null, name);
        checkConstructionFailure(host, typeMock, null);
    }

    private void checkConstructionFailure(Class<?> host, InjectionType type, String name) {
        try {
            new DefaultInjectionSite(host, type, name);
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}
