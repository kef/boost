package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Stamp;
import static au.net.netstorm.boost.spider.registry.Stamp.MULTIPLE;
import static au.net.netstorm.boost.spider.registry.Stamp.SINGLE;
import au.net.netstorm.boost.spider.linkage.Linkage;

public final class DefaultResolverEngineAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    ClassTestChecker testChecker = new DefaultClassTestChecker();
    ResolvedInstance resolvedInstanceDummy;
    ProviderEngine providerMock;
    Instances instancesMock;
    Factories factoriesMock;
    ResolverEngine subject;
    Factory factoryMock;
    Blueprint blueprintMock;
    Implementation implementationDummy;
    Object[] parametersDummy;
    Linkage linkageMock;
    Interface ifaceMock;

    public void setUpFixtures() {
        subject = new DefaultResolverEngine(instancesMock, factoriesMock, providerMock);
    }

    public void testCheckSynchronization() {
        testChecker.checkSynchronized(DefaultResolverEngine.class);
    }

    public void testNoResolvedInstance() {
        checkNoResolvedInstance(SINGLE, true);
        checkNoResolvedInstance(MULTIPLE, false);
    }

    public void testResolvedInstance() {
        setUpFactoryExpectations(SINGLE);
        setUpLinkageExpectations();
        expect.oneCall(instancesMock, true, "exists", ifaceMock, implementationDummy);
        expect.oneCall(instancesMock, resolvedInstanceDummy, "get", ifaceMock, implementationDummy);
        ResolvedInstance result = subject.resolve(linkageMock);
        assertEquals(resolvedInstanceDummy, result);
    }

    private void checkNoResolvedInstance(Stamp stamp, boolean expectInstancePut) {
        setupNoResolvedExpectations(stamp, expectInstancePut);
        ResolvedInstance result = subject.resolve(linkageMock);
        assertEquals(resolvedInstanceDummy, result);
    }

    private void setupNoResolvedExpectations(Stamp stamp, boolean expectInstancePut) {
        setUpFactoryExpectations(stamp);
        setUpLinkageExpectations();
        expect.oneCall(instancesMock, false, "exists", ifaceMock, implementationDummy);
        expect.oneCall(providerMock, resolvedInstanceDummy, "provide", implementationDummy, parametersDummy);
        if (expectInstancePut) expect.oneCall(instancesMock, VOID, "put", ifaceMock, implementationDummy, resolvedInstanceDummy);
    }

    private void setUpFactoryExpectations(Stamp stamp) {
        expect.oneCall(factoriesMock, factoryMock, "find", linkageMock);
        expect.oneCall(factoryMock, blueprintMock, "get", linkageMock);
        expect.oneCall(blueprintMock, stamp, "getStamp");
        expect.oneCall(blueprintMock, implementationDummy, "getImplementation");
        expect.oneCall(blueprintMock, parametersDummy, "getParameters");
    }

    private void setUpLinkageExpectations() {
        expect.oneCall(linkageMock, ifaceMock, "getIface");
    }
}
