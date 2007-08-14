package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.newer.assembly.NewDefaultTestDummy;
import au.net.netstorm.boost.spider.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.newer.core.Newer;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.DefaultBlueprint;
import au.net.netstorm.boost.spider.registry.GreenPrintsMonkey;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverEngineAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    private static final Stamp MULTIPLE = Stamp.MULTIPLE;
    ResolverEngine subject;
    ProviderEngine providerMock;
    GreenPrintsMonkey greenprintsMock;
    Instances instancesMock;
    NewerAssembler newerAssemblerMock;
    ResolvedInstance jimResolvedInstance;
    Newer newerImplMock;
    Flavour flavour;
    Interface jim = iface(Jim.class);
    Interface spoo = iface(Spoo.class);
    Interface newer = iface(NewDefaultTestDummy.class);
    Blueprint jimBlueprint;
    Implementation impl;
    ResolvedInstance spooInstance;

    public void setUpFixtures() {
        subject = new DefaultResolverEngine(providerMock, greenprintsMock, instancesMock, newerAssemblerMock);
        jimBlueprint = blueprint(NoArgJim.class, flavour);
        impl = jimBlueprint.getImplementation();
    }

    public void testNoResolvedInstance() {
        expect.oneCall(instancesMock, false, "exists", jim, flavour);
        expect.oneCall(greenprintsMock, jimBlueprint, "get", jim, flavour);
        expect.oneCall(providerMock, jimResolvedInstance, "provide", impl);
        ResolvedInstance result = subject.resolve(jim, flavour);
        assertEquals(jimResolvedInstance, result);
    }

    public void testResolvedInstance() {
        expect.oneCall(instancesMock, true, "exists", spoo, flavour);
        expect.oneCall(instancesMock, spooInstance, "get", spoo, flavour);
        ResolvedInstance result = subject.resolve(spoo, flavour);
        assertEquals(spooInstance, result);
    }

    public void testResolveNewer() {
        expect.oneCall(newerAssemblerMock, newerImplMock, "assemble", newer);
        ResolvedInstance expected = new DefaultBaseReference(newerImplMock);
        ResolvedInstance actual = subject.resolve(newer, flavour);
        assertEquals(expected, actual);
    }

    private Blueprint blueprint(Class cls, Flavour flavour) {
        Implementation impl = new DefaultImplementation(cls);
        return new DefaultBlueprint(MULTIPLE, impl, flavour);
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }
}
