package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.LazyFields;

public final class DefaultInstantiatorWithProviderAtomicTest extends LifecycleTestCase implements LazyFields {
    InstantiatorWithProvider subject = new DefaultInstantiatorWithProvider();
    Provider providerMock;
    Hat hat = new Hat();

    public void testProvide() {
        expect.oneCall(providerMock, hat, "provide", Hat.class);
        subject.createInstance(HatBox.class, providerMock);
    }
}
