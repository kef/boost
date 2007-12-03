package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class BlueprintedFactoryAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
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
    Boolean isSingleton;

    public void setUpFixtures() {
        subject = new BlueprintedFactory(blueprintsReadMock);
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

    public void testIsSingle() {
        checkIsSingle(Stamp.MULTIPLE, false);
        checkIsSingle(Stamp.SINGLE, true);
    }

    private void checkIsSingle(Stamp stamp, boolean expected) {
        expect.oneCall(blueprintsReadMock, blueprintMock, "get", ifaceDummy);
        expect.oneCall(blueprintMock, stamp, "getStamp");
        boolean actual = subject.isSingle(ifaceDummy);
        assertEquals(expected, actual);
    }

    private void setUpExpectations() {
        expect.oneCall(blueprintsReadMock, blueprintMock, "get", ifaceDummy);
        expect.oneCall(blueprintMock, implDummy, "getImplementation");
        expect.oneCall(providerMock, instanceMock, "provide", ifaceDummy, implDummy);
    }

    private void checkGetSucceeds() {
        ResolvedInstance actual = subject.get(ifaceDummy, implDummy, providerMock);
        assertEquals(instanceMock, actual);
    }
}
