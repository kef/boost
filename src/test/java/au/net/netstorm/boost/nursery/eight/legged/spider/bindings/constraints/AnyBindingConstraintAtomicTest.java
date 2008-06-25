package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class AnyBindingConstraintAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private BindingConstraint subject;
    BindingConstraintChecker checker;
    InjectionSite siteMock;

    public void setUpFixtures() {
        subject = new AnyBindingConstraint();
    }

     public void testAccept() {
         checker.checkAccept(true, subject, siteMock);
    }
}
