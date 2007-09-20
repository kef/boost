package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class GreenprintsFactoryAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    ResolvedInstance instanceMock;
    ImplementationRef hostDummy;
    ProviderEngine providerMock;
    Greenprints greenprintsMock;
    GreenprintsFactory subject;
    Implementation implDummy;
    Instances instancesMock;
    Blueprint blueprintMock;
    Interface ifaceDummy;
    Boolean exists;

    public void setUpFixtures() {
        subject = new GreenprintsFactory(greenprintsMock);
    }

    public void testCanHandle() {
        expect.oneCall(greenprintsMock, exists, "exists", ifaceDummy);
        boolean actual = subject.canHandle(ifaceDummy);
        assertEquals(exists, actual);
    }

    public void testGetSucceeds() {
        setUpExpectations();
        checkGetSucceeds();
    }

    private void setUpExpectations() {
        expect.oneCall(greenprintsMock, blueprintMock, "get", ifaceDummy);
        expect.oneCall(blueprintMock, implDummy, "getImplementation");
        expect.oneCall(providerMock, instanceMock, "provide", implDummy);
        expect.oneCall(blueprintMock, Stamp.SINGLE, "getStamp");
        expect.oneCall(instancesMock, false, "exists", ifaceDummy);
        expect.oneCall(instancesMock, VOID, "put", ifaceDummy, instanceMock);
    }

    private void checkGetSucceeds() {
        ResolvedInstance actual = subject.get(ifaceDummy, hostDummy, providerMock, instancesMock);
        assertEquals(instanceMock, actual);
    }
}
