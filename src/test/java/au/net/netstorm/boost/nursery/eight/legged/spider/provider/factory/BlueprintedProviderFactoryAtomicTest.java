package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.registry.BlueprintsRead;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.core.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.core.SingleProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.core.MultiProvider;
import au.net.netstorm.boost.gunge.type.Implementation;

public final class BlueprintedProviderFactoryAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private ProviderFactory subject;
    BlueprintsRead blueprintsMock;
    Blueprint blueprintMock;
    Linkage linkageMock;
    InjectionSite siteMock;
    Implementation implementationMock;

    public void setUpFixtures() {
        subject = new BlueprintedProviderFactory(blueprintsMock);
    }

    public void testCanHandle() {
        checkCanHandle(true);
        checkCanHandle(false);
    }

    public void testNu() {
        checkNu(Stamp.SINGLE, SingleProvider.class);
        checkNu(Stamp.MULTIPLE, MultiProvider.class);
    }

    public void testBadNu() {
        setCanHandleExpectations(false);
        try {
            subject.nu(siteMock);
            fail();
        } catch (IllegalArgumentException expected) {}
    }

    private void checkCanHandle(boolean expected) {
        setCanHandleExpectations(expected);
        boolean result = subject.canHandle(siteMock);
        assertEquals(expected, result);
    }

    private void checkNu(Stamp stamp, Class expected) {
        setCanHandleExpectations(true);
        setNuExpectations(stamp);
        checkNu(expected);
    }

    private void checkNu(Class expected) {
        Provider result = subject.nu(siteMock);
        Class actual = result.getClass();
        assertEquals(true, expected.isAssignableFrom(actual));
    }

    private void setCanHandleExpectations(boolean canHandle) {
        expect.oneCall(siteMock, linkageMock, "toLinkage");
        expect.oneCall(blueprintsMock, canHandle, "exists", linkageMock);
    }

    private void setNuExpectations(Stamp stamp) {
        expect.oneCall(blueprintsMock, blueprintMock, "get", linkageMock);
        expect.oneCall(blueprintMock, stamp, "getStamp");
        expect.oneCall(blueprintMock, implementationMock, "getImplementation");
    }
}
