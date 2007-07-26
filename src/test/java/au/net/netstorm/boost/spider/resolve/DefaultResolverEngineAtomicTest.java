package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.inject.newer.assembly.NewDefaultTestDummy;
import au.net.netstorm.boost.spider.inject.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.core.Newer;
import au.net.netstorm.boost.spider.registry.RegistryMaster;
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
    ResolverEngine subject;
    ProviderEngine providerMock;
    RegistryMaster registryMasterMock;
    NewerAssembler newerAssemblerMock;
    ResolvedInstance jimResolvedInstance;
    Newer newerImplMock;
    Flavour flavour;
    Interface jim = iface(Jim.class);
    Interface spoo = iface(Spoo.class);
    Interface newer = iface(NewDefaultTestDummy.class);
    Implementation jimImpl = impl(NoArgJim.class);
    ResolvedInstance spooInstance;
    Object[] noparams = {};

    public void setUpFixtures() {
        subject = new DefaultResolverEngine(providerMock, registryMasterMock, newerAssemblerMock);
    }

    public void testNoResolvedInstance() {
        expect.oneCall(registryMasterMock, Boolean.FALSE, "hasInstance", jim, flavour);
        expect.oneCall(registryMasterMock, jimImpl, "getImplementation", jim, flavour);
        expect.oneCall(providerMock, jimResolvedInstance, "provide", jimImpl, noparams);
        ResolvedInstance result = subject.resolve(jim, flavour);
        assertEquals(jimResolvedInstance, result);
    }

    public void testResolvedInstance() {
        expect.oneCall(registryMasterMock, Boolean.TRUE, "hasInstance", spoo, flavour);
        expect.oneCall(registryMasterMock, spooInstance, "getInstance", spoo, flavour);
        ResolvedInstance result = subject.resolve(spoo, flavour);
        assertEquals(spooInstance, result);
    }

    public void testResolveNewer() {
        expect.oneCall(newerAssemblerMock, newerImplMock, "assemble", newer);
        ResolvedInstance expected = new DefaultBaseReference(newerImplMock);
        ResolvedInstance actual = subject.resolve(newer, flavour);
        assertEquals(expected, actual);
    }

    private Implementation impl(Class cls) {
        return new DefaultImplementation(cls);
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }
}
