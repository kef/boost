package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverEngineAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    ResolvedInstance jimResolvedInstance;
    Interface jim = iface(Jim.class);
    Implementation hostDummy;
    ProviderEngine providerMock;
    Instances instancesMock;
    Factories factoriesMock;
    Blueprint jimBlueprint;
    ResolverEngine subject;
    Factory factoryMock;

    public void setUpFixtures() {
        subject = new DefaultResolverEngine(instancesMock, factoriesMock, providerMock);
    }

    public void testNoResolvedInstance() {
        expectExists(false);
        expectExists(false);
        expect.oneCall(factoriesMock, factoryMock, "find", jim);
        expect.oneCall(factoryMock, jimResolvedInstance, "get", jim, hostDummy, providerMock, instancesMock);
        ResolvedInstance result = subject.resolve(jim, hostDummy);
        assertEquals(jimResolvedInstance, result);
    }

    public void testThreadRace() {
        expectExists(true);
        expectExists(false);
        checkInstancesGet();
    }

    public void testResolvedInstance() {
        expectExists(true);
        checkInstancesGet();
    }

    private void checkInstancesGet() {
        expect.oneCall(instancesMock, jimResolvedInstance, "get", jim);
        ResolvedInstance result = subject.resolve(jim, hostDummy);
        assertEquals(jimResolvedInstance, result);
    }

    private void expectExists(boolean exists) {
        expect.oneCall(instancesMock, exists, "exists", jim);
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }
}
