package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;

public class DefaultImplementationLookupAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    private ImplementationLookup subject;
    Factories factoriesMock;
    LinkageFactory linkagesMock;
    Linkage linkageMock;
    Factory factoryMock;
    Blueprint blueprintMock;
    Implementation implMock;

    public void setUpFixtures() {
        subject = new DefaultImplementationLookup(factoriesMock, linkagesMock);
    }

    public void testGetImplementation() {
        expect.oneCall(linkagesMock, linkageMock, "nu", ImplementationLookup.class);
        expect.oneCall(factoriesMock, factoryMock, "find", linkageMock);
        expect.oneCall(factoryMock, blueprintMock, "get", linkageMock);
        expect.oneCall(blueprintMock, implMock, "getImplementation");
        expect.oneCall(implMock, DefaultImplementationLookup.class, "getImpl");
        checkGetImpl();
    }

    private void checkGetImpl() {
        Class<? extends ImplementationLookup> result = subject.getImplementation(ImplementationLookup.class);
        assertSame(DefaultImplementationLookup.class,  result);
    }
}
