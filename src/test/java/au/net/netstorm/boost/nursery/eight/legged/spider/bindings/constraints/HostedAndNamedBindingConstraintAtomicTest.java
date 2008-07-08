package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.testdata.DummyHolder;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class HostedAndNamedBindingConstraintAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private BindingConstraint subject;
    BindingConstraintChecker checker;
    Class hostDummy;
    String nameDummy;
    InjectionSite siteMock;

    public void setUpFixtures() {
        subject = new HostedAndNamedBindingConstraint(hostDummy, nameDummy);
    }

    public void testAccept() {
        expect.manyCalls(siteMock, true, "isConstrained");
        expect.oneCall(siteMock, hostDummy, "host");
        expect.oneCall(siteMock, nameDummy, "name");
        checker.checkAccept(true, subject, siteMock);
    }

    public void testDoNotAcceptHost() {
        expect.manyCalls(siteMock, true, "isConstrained");
        expect.oneCall(siteMock, DummyHolder.class, "host");
        checker.checkAccept(false, subject, siteMock);
    }

    public void testDoNotAcceptName() {
        expect.manyCalls(siteMock, true, "isConstrained");
        expect.oneCall(siteMock, hostDummy, "host");
        expect.oneCall(siteMock, nameDummy + "bad", "name");
        checker.checkAccept(false, subject, siteMock);
    }
}
