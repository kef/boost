package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.gaijin.Gaijinator;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.onion.Onion;
import au.net.netstorm.boost.pebble.type.DefaultImplementation;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultPebbleProviderEngineAtomicTest extends InteractionTestCase {
    private static final Interface PEBBLE = new DefaultInterface(Pebble.class);
    private static final Object[] NO_PARAMS = new Object[]{};
    private PebbleProviderEngine subject;
    private MockExpectations expect;
    private Onion onion;
    private Instantiator pebblator;
    private Gaijinator gaijinator; // FIX 1757 Drive up a DefaultGaijinator.
    private Injector injector;
    private Object[] parameters = {"Hi", "There"};
    private Implementation pebble;
    private Object rawRef = new Object();
    private Object wrappedRef = new Object();
    private Implementation gaijin = new DefaultImplementation(Barbarian.class);

    public void setupSubjects() {
        subject = new DefaultPebbleProviderEngine(PEBBLE, onion, injector, pebblator);
    }

    public void testPebbleProvider() {
        expect.oneCall(pebblator, rawRef, "instantiate", pebble, parameters);
        expect.oneCall(injector, VOID, "inject", rawRef);
        expect.oneCall(onion, wrappedRef, "onionise", rawRef);
        Object result = subject.provide(pebble, parameters);
        assertEquals(wrappedRef, result);
    }

    // FIX BREADCRUMB 1757 Reinstate?
//    public void testGaijinProvider() {
//        expect.oneCall(gaijinator, rawRef, "instantiate", type, NO_PARAMS);
//        subject.provide(Barbarian.class, NO_PARAMS);
//    }
}
