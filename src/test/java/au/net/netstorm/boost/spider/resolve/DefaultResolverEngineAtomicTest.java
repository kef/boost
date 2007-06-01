package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.inject.newer.assembly.NewDefaultTestDummy;
import au.net.netstorm.boost.spider.inject.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.core.Newer;
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
    ResolvedInstance jackResolvedInstance;
    Newer newerImpl;
    // FIX 1977 Test with real flavours.
    Flavour flavour;
    Interface jim = iface(Jim.class);
    Interface jack = iface(Jack.class);
    Interface spoo = iface(Spoo.class);
    Interface newer = iface(NewDefaultTestDummy.class);
    Implementation jimImpl = impl(NoArgJim.class);
    Implementation jackImpl = impl(OneArgJack.class);
    ResolvedInstance spooInstance;
    Object[] noparams = {};
    Jim jimInstance = new NoArgJim();

    public void setupSubjects() {
        subject = new DefaultResolverEngine(provider, registryMaster, newerAssembler);
    }

    public void testNoUnresolvedDependencies() {
        expect.oneCall(registryMaster, false, "hasInstance", jim, flavour);
        expect.oneCall(registryMaster, jimImpl, "getImplementation", jim, flavour);
        expect.oneCall(provider, jimResolvedInstance, "provide", jimImpl, noparams);
        ResolvedInstance result = subject.resolve(jim, flavour);
        assertEquals(jimResolvedInstance, result);
    }

    public void testOneUnresolvedDependencies() {
        expect.oneCall(registryMaster, false, "hasInstance", jack, flavour);
        expect.oneCall(registryMaster, jimImpl, "getImplementation", jim, flavour);
        expect.oneCall(provider, jimResolvedInstance, "provide", jimImpl, noparams);
        expect.oneCall(jimResolvedInstance, jimInstance, "getRef");
        expect.oneCall(registryMaster, false, "hasInstance", jim, flavour);
        expect.oneCall(registryMaster, jackImpl, "getImplementation", jack, flavour);
        expect.oneCall(provider, jackResolvedInstance, "provide", jackImpl, new Object[]{jimInstance});
        ResolvedInstance result = subject.resolve(jack, flavour);
        assertEquals(jackResolvedInstance, result);
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
