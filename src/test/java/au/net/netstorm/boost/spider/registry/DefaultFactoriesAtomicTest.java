package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.nursery.spider.registry.DefaultFactories;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultFactoriesAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
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

    public void testReinstate() {
        // FIX ()   2237 Reinstate.
    }

    // FIX ()   2237 Reinstate.
/*
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
        Factory actual = subject.find(linkage);
        assertEquals(factoryMock, actual);
    }

    private void setUpFactories(boolean canHandle) {
        subject.add(factoryMock);
        expect.oneCall(factoryMock, canHandle, "canHandle", ifaceDummy);
    }

    private void checkException() {
        try {
            subject.find(linkage);
            fail();
        } catch (CannotProvideException expected) { }
    }
*/
}
