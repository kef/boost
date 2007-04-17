package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.gaijin.Barbarian;
import au.net.netstorm.boost.spider.gaijin.Gaijinator;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.onion.Onionizer;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.BaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultProviderEngineAtomicTest extends InteractionTestCase {
    ProviderEngine subject;
    Onionizer onionizer;
    Instantiator instantiator;
    Gaijinator gaijinator; // FIX 1757 Drive up a DefaultGaijinator.
    InjectorEngine injector;
    Object[] parameters = {"Hi", "There"};
    Implementation provideMoi;
    Interface marker;
    BaseReference unresolved;
    Object rawRef;
    ResolvedInstance wrapped;
    Implementation gaijin = new DefaultImplementation(Barbarian.class);
    Interface initialisable = new DefaultInterface(Initialisable.class);

    public void setupSubjects() {
        subject = new DefaultProviderEngine(marker, onionizer, injector, instantiator);
    }

    public void testProvider() {
        checkProvider(false);
    }

    private void checkProvider(boolean initialise) {
        expect.oneCall(provideMoi, true, "is", marker);
        expect.oneCall(instantiator, unresolved, "instantiate", provideMoi, parameters);
        expect.oneCall(injector, VOID, "inject", unresolved);
        expect.oneCall(onionizer, wrapped, "onionise", unresolved);
        expect.oneCall(provideMoi, initialise, "is", initialisable);
        ResolvedInstance result = subject.provide(provideMoi, parameters);
        assertEquals(wrapped, result);
    }

    public void testNotMarker() {
        expect.oneCall(provideMoi, false, "is", marker);
        try {
            subject.provide(provideMoi, parameters);
            fail();
        } catch (IllegalCitizenException expected) { }
    }

    // FIX BREADCRUMB 1757 Reinstate?
//    public void testGaijinProvider() {
//        expect.oneCall(gaijinator, rawRef, "instantiate", type, NO_PARAMS);
//        subject.provide(Barbarian.class, NO_PARAMS);
//    }
}
