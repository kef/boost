package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class BlueprintedFactoryAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    private StampedResolvedInstance stamped;
    ResolvedInstance instanceMock;
    ImplementationRef hostDummy;
    ProviderEngine providerMock;
    BlueprintsRead blueprintsReadMock;
    BlueprintedFactory subject;
    Implementation implDummy;
    Blueprint blueprintMock;
    Interface ifaceDummy;
    Boolean exists;
    Stamp stampDummy;

    public void setUpFixtures() {
        subject = new BlueprintedFactory(blueprintsReadMock);
        stamped = new DefaultStampedResolvedInstance(instanceMock, stampDummy);
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
        expect.oneCall(blueprintMock, stampDummy, "getStamp");
    }

    private void checkGetSucceeds() {
        StampedResolvedInstance actual = subject.get(ifaceDummy, implDummy, providerMock);
        assertEquals(stamped, actual);
    }
}
