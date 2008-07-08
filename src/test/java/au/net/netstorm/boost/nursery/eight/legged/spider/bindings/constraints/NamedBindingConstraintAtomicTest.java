package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class NamedBindingConstraintAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private BindingConstraint subject;
    BindingConstraintChecker checker;
    String nameDummy;
    InjectionSite siteMock;

    public void setUpFixtures() {
        subject = new NamedBindingConstraint(nameDummy);
    }

    public void testAccept() {
        expect.oneCall(siteMock, true, "isConstrained");
        expect.oneCall(siteMock, nameDummy, "name");
        checker.checkAccept(true, subject, siteMock);
    }

    public void testDoNotAccept() {
        expect.oneCall(siteMock, true, "isConstrained");
        expect.oneCall(siteMock, nameDummy + nameDummy, "name");
        checker.checkAccept(false, subject, siteMock);
    }

    public void testDoNotAcceptNotConstrained() {
        expect.oneCall(siteMock, false, "isConstrained");
        checker.checkAccept(false, subject, siteMock);
    }
}
