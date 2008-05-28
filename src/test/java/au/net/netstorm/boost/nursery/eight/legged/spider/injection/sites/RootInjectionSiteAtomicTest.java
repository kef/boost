package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class RootInjectionSiteAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionSite subject;
    InjectionType typeMock;

    public void setUpFixtures() {
        subject = new RootInjectionSite(typeMock);
    }

    public void testInjectionSite() {
        checkHost();
        checkType(typeMock);
        checkName();
    }

    public void testInjectionSiteFailure() {
        try {
            new RootInjectionSite(null);
            fail();
        } catch (IllegalArgumentException expected) {}
    }

    private void checkHost() {
        try {
            subject.host();
            fail();
        } catch (AssertionError expected) {}
    }

    private void checkType(InjectionType expected) {
        InjectionType result = subject.type();
        assertSame(expected, result);
    }

    private void checkName() {
        try {
            subject.name();
            fail();
        } catch (AssertionError expected) {}
    }
}
