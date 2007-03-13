package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.onion.Onion;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class DefaultPebbleProviderAtomicTest extends InteractionTestCase {
    private PebbleProvider subject;
    private MockExpectations expect;
    private Onion onion;
    private Instantiator instantiator;
    private Injector injector;
    private Object[] parameters = {"Hi", "There"};
    private Class type = String.class;
    private Object rawRef = new Object();
    private Object wrappedRef = new Object();

    public void setupSubjects() {
        subject = new DefaultPebbleProvider(onion, injector, instantiator);
    }

    public void testNewer() {
        expect.oneCall(instantiator, rawRef, "instantiate", type, parameters);
        expect.oneCall(injector, VOID, "inject", rawRef);
        expect.oneCall(onion, wrappedRef, "onionize", rawRef);
        Object result = subject.provide(type, parameters);
        assertEquals(wrappedRef, result);
    }
}
