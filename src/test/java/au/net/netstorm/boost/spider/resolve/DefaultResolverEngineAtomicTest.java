package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.inject.newer.assembly.NewDefaultTestDummy;
import au.net.netstorm.boost.spider.inject.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.core.Newer;
import au.net.netstorm.boost.spider.registry.RegistryMaster;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverEngineAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    ResolverEngine subject;
    ProviderEngine provider;
    RegistryMaster registryMaster;
    NewerAssembler newerAssembler;
    ResolvedInstance jimResolvedInstance;
    Newer newerImpl;
    Flavour flavour;
    Interface jim = iface(Jim.class);
    Interface spoo = iface(Spoo.class);
    Interface newer = iface(NewDefaultTestDummy.class);
    Implementation jimImpl = impl(NoArgJim.class);
    ResolvedInstance spooInstance;
    Object[] noparams = {};

    public void setupSubjects() {
        subject = new DefaultResolverEngine(provider, registryMaster, newerAssembler);
    }

    public void testNoResolvedInstance() {
        expect.oneCall(registryMaster, false, "hasInstance", jim, flavour);
        expect.oneCall(registryMaster, jimImpl, "getImplementation", jim, flavour);
        expect.oneCall(provider, jimResolvedInstance, "provide", jimImpl, noparams);
        ResolvedInstance result = subject.resolve(jim, flavour);
        assertEquals(jimResolvedInstance, result);
    }

    public void testResolvedInstance() {
        expect.oneCall(registryMaster, true, "hasInstance", spoo, flavour);
        expect.oneCall(registryMaster, spooInstance, "getInstance", spoo, flavour);
        ResolvedInstance result = subject.resolve(spoo, flavour);
        assertEquals(spooInstance, result);
    }

    public void testResolveNewer() {
        expect.oneCall(newerAssembler, newerImpl, "assemble", newer);
        ResolvedInstance expected = new DefaultBaseReference(newerImpl);
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
