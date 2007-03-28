package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.pebble.core.ProviderEngine;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverAtomicTest extends InteractionTestCase {
    Resolver subject;
    ProviderEngine provider;
    RegistryMaster registryMaster;
    ResolvedInstance jimInstance;
    ResolvedInstance jackInstance;
    Interface jim = iface(Jim.class);
    Interface jack = iface(Jack.class);
    Interface spoo = iface(Spoo.class);
    Implementation jimImpl = impl(NoArgJim.class);
    Implementation jackImpl = impl(OneArgJack.class);
    ResolvedInstance spooInstance;
    Object[] noparams = {};

    public void setupSubjects() {
        subject = new DefaultResolver(provider, registryMaster);
    }

    public void testNoUnresolvedDependencies() {
        expect.oneCall(registryMaster, false, "hasInstance", jim);
        expect.oneCall(registryMaster, jimImpl, "getImplementation", jim);
        expect.oneCall(provider, jimInstance, "provide", jimImpl, noparams);
        ResolvedInstance result = subject.resolve(jim);
        assertEquals(jimInstance, result);
    }

    public void testOneUnresolvedDependencies() {
        expect.oneCall(registryMaster, false, "hasInstance", jack);
        expect.oneCall(registryMaster, jimImpl, "getImplementation", jim);
        expect.oneCall(provider, jimInstance, "provide", jimImpl, noparams);
        expect.oneCall(registryMaster, false, "hasInstance", jim);
        expect.oneCall(registryMaster, jackImpl, "getImplementation", jack);
        expect.oneCall(provider, jackInstance, "provide", jackImpl, new Object[]{jimInstance});
        ResolvedInstance result = subject.resolve(jack);
        assertEquals(jackInstance, result);
    }

    public void testResolvedInstance() {
        expect.oneCall(registryMaster, true, "hasInstance", spoo);
        expect.oneCall(registryMaster, spooInstance, "getInstance", spoo);
        ResolvedInstance result = subject.resolve(spoo);
        assertEquals(spooInstance, result);
    }

    private Implementation impl(Class cls) {
        return new DefaultImplementation(cls);
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }
}
