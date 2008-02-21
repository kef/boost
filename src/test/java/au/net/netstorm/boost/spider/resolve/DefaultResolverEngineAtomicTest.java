package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.register.Blueprint;
import au.net.netstorm.boost.spider.register.Factories;
import au.net.netstorm.boost.spider.register.Factory;
import au.net.netstorm.boost.spider.register.Instances;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverEngineAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    ClassTestChecker testChecker = new DefaultClassTestChecker();
    Interface iface = new DefaultInterface(Jim.class);
    ResolvedInstance resolvedInstanceDummy;
    ProviderEngine providerMock;
    Implementation hostDummy;
    Instances instancesMock;
    Factories factoriesMock;
    ResolverEngine subject;
    Blueprint blueprint;
    Factory factoryMock;
    Blueprint blueprintMock;
    Implementation implementationDummy;
    Object[] parametersDummy;

    public void setUpFixtures() {
        subject = new DefaultResolverEngine(instancesMock, factoriesMock, providerMock);
    }

    public void testCheckSynchronization() {
        testChecker.checkSynchronized(DefaultResolverEngine.class);
    }

    // FIX ()   2237 Reinstate.
/*
    public void testNoResolvedInstance() {
        checkNoResolvedInstance(SINGLE, true);
        checkNoResolvedInstance(MULTIPLE, false);
    }

    public void testResolvedInstance() {
        setUpFactoryExpectations(SINGLE);
        expect.oneCall(instancesMock, true, "exists", implementationDummy);
        expect.oneCall(instancesMock, resolvedInstanceDummy, "get", implementationDummy);
        ResolvedInstance result = subject.resolve(linkage);
        assertEquals(resolvedInstanceDummy, result);
    }

    private void checkNoResolvedInstance(Stamp stamp, boolean expectInstancePut) {
        setupNoResolvedExpectations(stamp, expectInstancePut);
        ResolvedInstance result = subject.resolve(linkage);
        assertEquals(resolvedInstanceDummy, result);
    }

    private void setupNoResolvedExpectations(Stamp stamp, boolean expectInstancePut) {
        setUpFactoryExpectations(stamp);
        expect.oneCall(instancesMock, false, "exists", implementationDummy);
        expect.oneCall(providerMock, resolvedInstanceDummy, "provide", implementationDummy, parametersDummy);
        if (expectInstancePut) expect.oneCall(instancesMock, VOID, "put", implementationDummy, resolvedInstanceDummy);
    }

    private void setUpFactoryExpectations(Stamp stamp) {
        expect.oneCall(factoriesMock, factoryMock, "find", iface);
        expect.oneCall(factoryMock, blueprintMock, "get", hostDummy, iface);
        expect.oneCall(blueprintMock, stamp, "getStamp");
        expect.oneCall(blueprintMock, implementationDummy, "getImplementation");
        expect.oneCall(blueprintMock, parametersDummy, "getParameters");
    }
*/
}
