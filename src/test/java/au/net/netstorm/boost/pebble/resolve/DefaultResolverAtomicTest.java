package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.Registry;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInstance;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultResolverAtomicTest extends InteractionTestCase {
    Resolver subject;
    PebbleProviderEngine provider;
    Registry registry;
    Object jimInstance;
    Object jackInstance;
    Interface jim = iface(Jim.class);
    Interface jack = iface(Jack.class);
    Interface spoo = iface(Spoo.class);
    Implementation jimImpl = impl(NoArgJim.class);
    Implementation jackImpl = impl(OneArgJack.class);
    Spoo kseniaSpoo = new KseniaSpoo();
    Instance spooInstance = new DefaultInstance(kseniaSpoo);
    Object[] noparams = {};

    public void setupSubjects() {
        subject = new DefaultResolver(provider, registry);
    }

    public void testNoUnresolvedDependencies() {
        expect.oneCall(registry, false, "hasInstance", jim);
        expect.oneCall(registry, jimImpl, "getImplementation", jim);
        expect.oneCall(provider, jimInstance, "provide", jimImpl, noparams);
        Object result = subject.resolve(jim);
        assertEquals(jimInstance, result);
    }

    public void testOneUnresolvedDependencies() {
        expect.oneCall(registry, false, "hasInstance", jack);
        expect.oneCall(registry, jimImpl, "getImplementation", jim);
        expect.oneCall(provider, jimInstance, "provide", jimImpl, noparams);
        expect.oneCall(registry, false, "hasInstance", jim);
        expect.oneCall(registry, jackImpl, "getImplementation", jack);
        expect.oneCall(provider, jackInstance, "provide", jackImpl, new Object[]{jimInstance});
        Object result = subject.resolve(jack);
        assertEquals(jackInstance, result);
    }

    public void testResolvedInstance() {
        expect.oneCall(registry, true, "hasInstance", spoo);
        expect.oneCall(registry, spooInstance, "getInstance", spoo);
        Object result = subject.resolve(spoo);
        assertEquals(kseniaSpoo, result);
    }

    private Implementation impl(Class cls) {
        return new DefaultImplementation(cls);
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }
}
