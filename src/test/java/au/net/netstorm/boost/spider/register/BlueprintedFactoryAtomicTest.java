package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.HasFixtures;
import au.net.netstorm.boost.gunge.marker.LazyFields;
import au.net.netstorm.boost.spider.linkage.Linkage;

public final class BlueprintedFactoryAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    BlueprintedFactory subject;
    BlueprintsRead blueprintsReadMock;
    Blueprint blueprintDummy;
    Linkage linkageDummy;
    Boolean exists;

    public void setUpFixtures() {
        subject = new BlueprintedFactory(blueprintsReadMock);
    }

    public void testCanHandle() {
        expect.oneCall(blueprintsReadMock, exists, "exists", linkageDummy);
        boolean actual = subject.canHandle(linkageDummy);
        assertEquals(exists, actual);
    }

    public void testGet() {
        expect.oneCall(blueprintsReadMock, blueprintDummy, "get", linkageDummy);
        Blueprint actual = subject.get(linkageDummy);
        assertEquals(blueprintDummy, actual);
    }
}
