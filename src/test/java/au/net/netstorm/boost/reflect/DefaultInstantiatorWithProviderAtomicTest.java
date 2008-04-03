package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.LazyFields;
import au.net.netstorm.boost.provider.Provider;

public final class DefaultInstantiatorWithProviderAtomicTest extends LifecycleTestCase implements LazyFields {
    // FIX 2290 InstantiatorWithProvider smells real bad.  Sort this out.
    InstantiatorWithProvider subject = new DefaultInstantiatorWithProvider();
    Provider providerMock;
    Hat hat = new Hat();

    public void testProvide() {
        expect.oneCall(providerMock, hat, "provide", Hat.class);
        subject.createInstance(HatBox.class, providerMock);
    }
}
