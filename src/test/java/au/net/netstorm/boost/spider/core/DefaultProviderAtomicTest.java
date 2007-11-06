package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultProviderAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    private static final Interface NO_IFACE = new DefaultInterface(NoInterface.class);
    Implementation implementation = new DefaultImplementation(SmoothRock.class);
    Object[] noParams = {};
    Provider subject;
    ProviderEngine engineMock;
    ResolvedInstance providedMock;
    Object ref;

    public void setUpFixtures() {
        subject = new DefaultProvider(engineMock);
    }

    public void testShortcut() {
        expect.oneCall(engineMock, providedMock, "provide", NO_IFACE, implementation, noParams);
        expect.oneCall(providedMock, ref, "getRef");
        Object result = subject.provide(SmoothRock.class);
        assertEquals(ref, result);
    }
}
