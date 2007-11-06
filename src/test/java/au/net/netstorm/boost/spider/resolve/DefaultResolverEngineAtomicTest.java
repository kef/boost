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
    // FIX 2215 Remove spoo fixtures...use jim instead.
    ClassTestChecker testChecker = new DefaultClassTestChecker();
    ResolvedInstance jimResolvedInstanceDummy;
    Interface spoo = iface(Spoo.class);
    Interface jim = iface(Jim.class);
    ResolvedInstance spooInstance;
    StampedResolvedInstance stampedInstanceMock;
    Implementation hostDummy;
    ProviderEngine providerMock;
    Instances instancesMock;
    Factories factoriesMock;
    Blueprint jimBlueprint;
    ResolverEngine subject;
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
        expect.oneCall(instancesMock, false, "exists", jim);
        expect.oneCall(factoriesMock, factoryMock, "find", jim);
        expect.oneCall(factoryMock, stampedInstanceMock, "get", jim, hostDummy, providerMock);
        expect.oneCall(stampedInstanceMock, jimResolvedInstanceDummy, "getInstance");
        expect.oneCall(stampedInstanceMock, stamp, "getStamp");
        expect.oneCall(instancesMock, false, "exists", jim);
        expect.oneCall(instancesMock, VOID, "put", jim, jimResolvedInstanceDummy);
        ResolvedInstance result = subject.resolve(jim, hostDummy);
        assertEquals(jimResolvedInstanceDummy, result);
    }

    public void testResolvedInstance() {
        expect.oneCall(instancesMock, true, "exists", spoo);
        expect.oneCall(instancesMock, spooInstance, "get", spoo);
        ResolvedInstance result = subject.resolve(spoo, hostDummy);
        assertEquals(spooInstance, result);
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }
}
