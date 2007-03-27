package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.gaijin.Barbarian;
import au.net.netstorm.boost.pebble.gaijin.Gaijinator;
import au.net.netstorm.boost.pebble.inject.newer.core.InjectorEngine;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.onion.Onion;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.BaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultPebbleProviderEngineAtomicTest extends InteractionTestCase {
    PebbleProviderEngine subject;
    Onion onion;
    Instantiator pebblator;
    Gaijinator gaijinator; // FIX 1757 Drive up a DefaultGaijinator.
    InjectorEngine injector;
    Object[] parameters = {"Hi", "There"};
    Implementation pebble;
    Interface marker;
    BaseReference unresolved;
    Object rawRef;
    Instance wrapped;
    Implementation gaijin = new DefaultImplementation(Barbarian.class);

    public void setupSubjects() {
        subject = new DefaultPebbleProviderEngine(marker, onion, injector, pebblator);
    }

    public void testPebbleProvider() {
        expect.oneCall(pebble, true, "is", marker);
        expect.oneCall(pebblator, unresolved, "instantiate", pebble, parameters);
        expect.oneCall(injector, VOID, "inject", unresolved);
        expect.oneCall(onion, wrapped, "onionise", unresolved);
        Instance result = subject.provide(pebble, parameters);
        assertEquals(wrapped, result);
    }

    public void testNotMarker() {
        expect.oneCall(pebble, false, "is", marker);
        try {
            subject.provide(pebble, parameters);
            fail();
        } catch (IllegalCitizenException expected) { }
    }

    // FIX BREADCRUMB 1757 Reinstate?
//    public void testGaijinProvider() {
//        expect.oneCall(gaijinator, rawRef, "instantiate", type, NO_PARAMS);
//        subject.provide(Barbarian.class, NO_PARAMS);
//    }
}
