package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.impl.ImplMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class ImplicitFactoryAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    ImplicitFactory subject;
    ImplMaster implerMock;
    Instances instancesMock;
    Interface ifaceDummy;
    Boolean canHandle;
    Implementation hostDummy;
    ProviderEngine providerMock;
    Implementation implDummy;
    ResolvedInstance instanceDummy;

    public void setUpFixtures() {
        subject = new ImplicitFactory(implerMock, instancesMock);
    }

    public void testCanHandle() {
        expect.oneCall(implerMock, canHandle, "hasImpl", ifaceDummy);
        boolean actual = subject.canHandle(ifaceDummy);
        assertEquals(canHandle, actual);
    }

    public void testGet() {
        expect.oneCall(implerMock, implDummy, "impl", ifaceDummy);
        expect.oneCall(providerMock, instanceDummy, "provide", implDummy);
        expect.oneCall(instancesMock, false, "exists", ifaceDummy);
        expect.oneCall(instancesMock, VOID, "put", ifaceDummy, instanceDummy);
        ResolvedInstance actual = subject.get(ifaceDummy, hostDummy, providerMock);
        assertEquals(instanceDummy, actual);
    }
}