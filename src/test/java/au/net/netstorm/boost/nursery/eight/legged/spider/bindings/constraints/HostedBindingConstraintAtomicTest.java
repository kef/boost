package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.testdata.DummyHolder;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class HostedBindingConstraintAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private BindingConstraint subject;
    BindingConstraintChecker checker;
    Class hostDummy;
    InjectionSite siteMock;

    public void setUpFixtures() {
        subject = new HostedBindingConstraint(hostDummy);
    }

    public void testAccept() {
        expect.oneCall(siteMock, hostDummy, "host");
        checker.checkAccept(true, subject, siteMock);
    }

    public void testDoNotAccept() {
        expect.oneCall(siteMock, DummyHolder.class, "host");
        checker.checkAccept(false, subject, siteMock);
    }
}
