package au.net.netstorm.boost.nursery.eight.legged.spider.provider.multiplicity;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class MultiProviderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private ProviderMultiplicity subject;

    Provider providerMock;
    public void setUpFixtures() {
        subject = new MultiProvider(providerMock);
    }

    public void testNu() {
        Object instance = new Object();
        Object args = new Object[0];
        expect.manyCalls(providerMock, instance, "nu", args);
        checkNu(instance);
        checkNu(instance);
    }

    private void checkNu(Object expected) {
        Object result = subject.nu();
        assertSame(expected, result);
    }
}
