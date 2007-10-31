package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class BlueprintedFactoryAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    ResolvedInstance instanceMock;
    ImplementationRef hostDummy;
    ProviderEngine providerMock;
    BlueprintsRead blueprintsReadMock;
    BlueprintedFactory subject;
    Implementation implDummy;
    Instances instancesMock;
    Blueprint blueprintMock;
    Interface ifaceDummy;
    Boolean exists;

    public void setUpFixtures() {
        subject = new BlueprintedFactory(blueprintsReadMock, instancesMock);
    }

    public void testCanHandle() {
        expect.oneCall(blueprintsReadMock, exists, "exists", ifaceDummy);
        boolean actual = subject.canHandle(ifaceDummy);
        assertEquals(exists, actual);
    }

    public void testGetSucceeds() {
        setUpExpectations();
        checkGetSucceeds();
    }

    private void setUpExpectations() {
        expect.oneCall(blueprintsReadMock, blueprintMock, "get", ifaceDummy);
        expect.oneCall(blueprintMock, implDummy, "getImplementation");
        expect.oneCall(providerMock, instanceMock, "provide", implDummy);
        expect.oneCall(blueprintMock, Stamp.SINGLE, "getStamp");
        expect.oneCall(instancesMock, VOID, "put", ifaceDummy, instanceMock);
    }

    private void checkGetSucceeds() {
        ResolvedInstance actual = subject.get(ifaceDummy, implDummy, providerMock);
        assertEquals(instanceMock, actual);
    }
}
