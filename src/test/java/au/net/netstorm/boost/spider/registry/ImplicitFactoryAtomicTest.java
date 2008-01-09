package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.impl.ImplMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class ImplicitFactoryAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    private static final Object[] NO_PARAMS = {};
    ImplicitFactory subject;
    ImplMaster implerMock;
    Interface ifaceDummy;
    Boolean canHandle;
    Implementation hostDummy;
    Implementation implDummy;

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
        Blueprint expected = new DefaultBlueprint(Stamp.SINGLE, implDummy, NO_PARAMS);
        Blueprint actual = subject.get(hostDummy, ifaceDummy);
        assertEquals(expected, actual);
    }
}
