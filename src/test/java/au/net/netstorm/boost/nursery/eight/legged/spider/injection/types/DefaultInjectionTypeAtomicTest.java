package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultInjectionTypeAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionType subject;
    InjectionTypeChecker checker;

    public void setUpFixtures() {
        subject = new DefaultInjectionType(String.class);
    }

    public void testInjectionType() {
        checker.checkType(subject, subject, String.class);
    }

    public void testInjectionTypeFailure() {
        try {
            new DefaultInjectionType(null);
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}
