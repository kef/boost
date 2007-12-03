package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.impl.ImplMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class ImplicitFactoryAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    ImplicitFactory subject;
    ImplMaster implerMock;
    Interface ifaceDummy;
    Boolean canHandle;
    Implementation hostDummy;
    ProviderEngine providerMock;
    Implementation implDummy;
    ResolvedInstance instanceDummy;

    public void setUpFixtures() {
        subject = new ImplicitFactory(implerMock);
    }

    public void testCanHandle() {
        expect.oneCall(implerMock, canHandle, "hasImpl", ifaceDummy);
        boolean actual = subject.canHandle(ifaceDummy);
        assertEquals(canHandle, actual);
    }

    public void testGet() {
        expect.oneCall(implerMock, implDummy, "impl", ifaceDummy);
        expect.oneCall(providerMock, instanceDummy, "provide", ifaceDummy, implDummy);
        ResolvedInstance actual = subject.get(ifaceDummy, hostDummy, providerMock);
        assertEquals(instanceDummy, actual);
    }

    public void testIsSingle() {
        boolean actual = subject.isSingle(ifaceDummy);
        assertEquals(true, actual);
    }
}
