package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.spider.registry.StampedResolvedInstance;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverEngineAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    ClassTestChecker testChecker = new DefaultClassTestChecker();
    Interface iface = new DefaultInterface(Jim.class);
    StampedResolvedInstance stampedInstanceMock;
    ResolvedInstance resolvedInstanceDummy;
    ProviderEngine providerMock;
    Implementation hostDummy;
    Instances instancesMock;
    Factories factoriesMock;
    ResolverEngine subject;
    Blueprint blueprint;
    Factory factoryMock;
    // FIX 2215 Need a test for Stamp.MULTIPLE also.
    Stamp stamp = Stamp.SINGLE;

    public void setUpFixtures() {
        subject = new DefaultResolverEngine(instancesMock, factoriesMock, providerMock);
    }

    public void testCheckSynchronization() {
        testChecker.checkSynchronized(DefaultResolverEngine.class);
    }

    public void testNoResolvedInstance() {
        expect.oneCall(instancesMock, false, "exists", iface);
        expect.oneCall(factoriesMock, factoryMock, "find", iface);
        expect.oneCall(factoryMock, stampedInstanceMock, "get", iface, hostDummy, providerMock);
        expect.oneCall(stampedInstanceMock, resolvedInstanceDummy, "getInstance");
        expect.oneCall(stampedInstanceMock, stamp, "getStamp");
        expect.oneCall(instancesMock, VOID, "put", iface, resolvedInstanceDummy);
        ResolvedInstance result = subject.resolve(iface, hostDummy);
        assertEquals(resolvedInstanceDummy, result);
    }

    public void testResolvedInstance() {
        expect.oneCall(instancesMock, true, "exists", iface);
        expect.oneCall(instancesMock, resolvedInstanceDummy, "get", iface);
        ResolvedInstance result = subject.resolve(iface, hostDummy);
        assertEquals(resolvedInstanceDummy, result);
    }
}
