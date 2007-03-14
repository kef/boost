package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.onion.Onion;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class DefaultPebbleProviderAtomicTest extends InteractionTestCase {
    private static final Object[] NO_PARAMS = new Object[]{};
    private PebbleProvider subject;
    private MockExpectations expect;
    private Onion onion;
    private Instantiator pebblator;
    private Instantiator gaijinator;
    private Injector injector;
    private Object[] parameters = {"Hi", "There"};
    private Class type = String.class;
    private Object rawRef = new Object();
    private Object wrappedRef = new Object();

    public void setupSubjects() {
        subject = new DefaultPebbleProvider(onion, injector, pebblator, gaijinator);
    }

    public void testProvider() {
        expect.oneCall(pebblator, rawRef, "instantiate", type, parameters);
        expect.oneCall(injector, VOID, "inject", rawRef);
        expect.oneCall(onion, wrappedRef, "onionise", rawRef);
        Object result = subject.provide(type, parameters);
        assertEquals(wrappedRef, result);
    }

//    public void testGaijin() {
//        subject.provide(HashSet.class, NO_PARAMS);
//    }
}
