package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.ExplicitImplementationRegistry;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultResolverAtomicTest extends InteractionTestCase {
    private Resolver subject;
    private PebbleProviderEngine provider;
    private ExplicitImplementationRegistry registry;
    private Object jimInstance;
    private Object jackInstance;
    private Interface jim = iface(Jim.class);
    private Interface jack = iface(Jack.class);
    private Implementation jimImpl = impl(NoArgJim.class);
    private Implementation jackImpl = impl(OneArgJack.class);
    private Object[] noparams = {};

    public void setupSubjects() {
        subject = new DefaultResolver(provider, registry);
    }

    public void testNoUnresolvedDependencies() {
        expect.oneCall(registry, jimImpl, "find", jim);
        expect.oneCall(provider, jimInstance, "provide", jimImpl, noparams);
        Object result = subject.resolve(jim);
        assertEquals(jimInstance, result);
    }

    public void testOneUnresolvedDependencies() {
        expect.oneCall(registry, jimImpl, "find", jim);
        expect.oneCall(provider, jimInstance, "provide", jimImpl, noparams);
        expect.oneCall(registry, jackImpl, "find", jack);
        expect.oneCall(provider, jackInstance, "provide", jackImpl, new Object[]{jimInstance});
        Object result = subject.resolve(jack);
        assertEquals(jackInstance, result);
    }

    private Implementation impl(Class cls) {
        return new DefaultImplementation(cls);
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }
}
