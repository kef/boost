package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultInstantiatorWithProviderAtomicTest extends InteractionTestCase {

    InstantiatorWithProvider subject = new DefaultInstantiatorWithProvider();
    Provider provider;
    Hat hat = new Hat();

    public void testXxx() {
        expect.oneCall(provider, hat, "provide", Hat.class);
        subject.createInstance(HatBox.class, provider);
    }
}
