package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class BlueprintedFactoryAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    BlueprintedFactory subject;
    ResolvedInstance instanceMock;
    ImplementationRef hostDummy;
    BlueprintsRead blueprintsReadMock;
    Implementation implDummy;
    Blueprint blueprintDummy;
    Interface ifaceDummy;
    Boolean exists;

    public void setUpFixtures() {
        subject = new BlueprintedFactory(blueprintsReadMock);
    }

    public void testCanHandle() {
        expect.oneCall(blueprintsReadMock, exists, "exists", ifaceDummy);
        boolean actual = subject.canHandle(ifaceDummy);
        assertEquals(exists, actual);
    }

    public void testGet() {
        expect.oneCall(blueprintsReadMock, blueprintDummy, "get", implDummy, ifaceDummy);
        Blueprint actual = subject.get(implDummy, ifaceDummy);
        assertEquals(blueprintDummy, actual);
    }
}
