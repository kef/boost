package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class InstanceProviderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Provider subject;
    private Object expected;

    public void setUpFixtures() {
        expected = new Object();
        subject = new InstanceProvider(expected);
    }

    public void testNu() {
        Object result = subject.nu();
        assertSame(expected, result);
    }

    public void testNuFailure() {
        try {
            subject.nu("any arg");
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}
