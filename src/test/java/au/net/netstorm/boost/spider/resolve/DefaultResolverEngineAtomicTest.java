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
    // FIX BREADCRUMB 2183 Check for synchronisation.
    ResolvedInstance jimResolvedInstance;
    Interface spoo = iface(Spoo.class);
    Interface jim = iface(Jim.class);
    ResolvedInstance spooInstance;
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
        expect.oneCall(instancesMock, false, "exists", jim);
        expect.oneCall(factoriesMock, factoryMock, "find", jim);
        expect.oneCall(factoryMock, spooInstance, "get", jim, hostDummy, providerMock, instancesMock);
        ResolvedInstance result = subject.resolve(jim, hostDummy);
        assertEquals(jimResolvedInstance, result);
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
