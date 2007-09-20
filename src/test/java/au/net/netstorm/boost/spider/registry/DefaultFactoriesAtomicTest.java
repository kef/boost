package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultFactoriesAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    ResolvedInstance resolvedInstanceDummy;
    ProviderEngine providerDummy;
    ImplementationRef hostDummy;
    Instances instancesDummy;
    Interface ifaceDummy;
    Factory factoryMock;
    Factories subject;

    public void setUpFixtures() {
        subject = new DefaultFactories();
    }

    public void testGet() {
        checkGetFailsNoFactories();
        checkGetHasFactories();
        checkGetSucceeds();
    }

    private void checkGetFailsNoFactories() {
        checkException();
    }

    private void checkGetHasFactories() {
        setUpFactories(false);
        checkException();
    }

    private void checkGetSucceeds() {
        setUpFactories(true);
        expect.oneCall(factoryMock, resolvedInstanceDummy, "get", ifaceDummy, hostDummy, providerDummy, instancesDummy);
        ResolvedInstance actual = subject.get(ifaceDummy, hostDummy, providerDummy, instancesDummy);
        assertEquals(resolvedInstanceDummy, actual);
    }

    private void setUpFactories(boolean canHandle) {
        subject.add(factoryMock);
        expect.oneCall(factoryMock, canHandle, "canHandle", ifaceDummy);
    }

    private void checkException() {
        try {
            subject.get(ifaceDummy, hostDummy, providerDummy, instancesDummy);
            fail();
        } catch (CannotProvideException expected) { }
    }
}
