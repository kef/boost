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
    private Resolver subject;
    private PebbleProviderEngine provider;
    private Registry registry;
    private Object jimInstance;
    private Object jackInstance;
    private Interface jim = iface(Jim.class);
    private Interface jack = iface(Jack.class);
    private Interface spoo = iface(Spoo.class);
    private Implementation jimImpl = impl(NoArgJim.class);
    private Implementation jackImpl = impl(OneArgJack.class);
    private Spoo kseniaSpoo = new KseniaSpoo();
    private Instance spooInstance = new DefaultInstance(kseniaSpoo);

    private Object[] noparams = {};

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
