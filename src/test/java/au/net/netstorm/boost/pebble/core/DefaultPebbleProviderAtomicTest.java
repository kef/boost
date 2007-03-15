package au.net.netstorm.boost.pebble.core;

import java.util.HashSet;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.onion.Onion;
import au.net.netstorm.boost.pebble.type.DefaultImplementation;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class DefaultPebbleProviderAtomicTest extends InteractionTestCase {
    private static final Object[] NO_PARAMS = new Object[]{};
    private PebbleProvider subject;
    private MockExpectations expect;
    private Onion onion;
    private Instantiator pebblator;
    private Gaijinator gaijinator; // FIX 1715 Drive up a DefaultGaijin.
    private Injector injector;
    private Object[] parameters = {"Hi", "There"};
    private Class type = String.class;
    private Object rawRef = new Object();
    private Object wrappedRef = new Object();
    private Implementation gaijin = new DefaultImplementation(HashSet.class);
    private Implementation[] gaijins = {gaijin};

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

    // FIX BREADCRUMB 1715 Reinstate.
/*
    public void testGaijin() {
        expect.oneCall(gaijinator, rawRef, "instantiate", type, NO_PARAMS);
        subject.provide(HashSet.class, NO_PARAMS);
    }
*/
}
