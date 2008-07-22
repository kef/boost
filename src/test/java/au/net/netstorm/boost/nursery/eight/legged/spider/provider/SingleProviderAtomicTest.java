package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class SingleProviderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Provider subject;
    Provider providerMock;

    public void setUpFixtures() {
        subject = new SingleProvider(providerMock);
    }

    public void testNuFailure() {
        try {
            subject.nu("arg");
            fail();
        } catch (IllegalArgumentException expected) {}
    }

    public void testNu() {
        Object instance = new Object();
        Object args = new Object[0];
        expect.oneCall(providerMock, instance, "nu", args);
        checkNu(instance);
        checkNu(instance);
    }

    private void checkNu(Object instance) {
        Object result = subject.nu();
        assertSame(instance, result);
    }
}
