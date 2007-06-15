package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.newer.DefaultResolvedThings;
import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.spider.gaijin.Barbarian;
import au.net.netstorm.boost.spider.gaijin.Gaijinator;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.BaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultProviderEngineAtomicTest extends InteractionTestCase implements HasFixtures, UsesAutoMocks {
    ProviderEngine subject;
    Onionizer onionizer;
    Instantiator instantiator;
    Gaijinator gaijinator; // FIX 1757 Drive up a DefaultGaijinator.
    InjectorEngine injector;
    Object[] parameters = {"Hi", "There"};
    Implementation providezMoi;
    BaseReference unresolved;
    Object rawRef;
    ResolvedInstance wrapped;
    Initialisable initialisable;
    Implementation gaijin = new DefaultImplementation(Barbarian.class);
    Interface initMarker = new DefaultInterface(Initialisable.class);
    ResolvedThings resolvedThings = new DefaultResolvedThings();

    public void setUpFixtures() {
        subject = new DefaultProviderEngine(onionizer, injector, instantiator);
    }

    public void testProvider() {
        checkProvider(false);
        checkProvider(true);
    }

    private void checkProvider(boolean initialise) {
        resolvedThings.clear();
        expect.oneCall(instantiator, unresolved, "instantiate", providezMoi, parameters);
        expect.oneCall(injector, VOID, "inject", unresolved);
        expect.oneCall(onionizer, wrapped, "onionise", unresolved);
        optionalInit(initialise);
        ResolvedInstance result = subject.provide(providezMoi, parameters);
        assertEquals(wrapped, result);
    }

    private void optionalInit(boolean initialise) {
        expect.oneCall(providezMoi, initialise, "is", initMarker);
        if (!initialise) return;
        expect.oneCall(unresolved, initialisable, "getRef");
        expect.oneCall(initialisable, VOID, "initialise");
    }

    // FIX BREADCRUMB 1757 Reinstate?
//    public void testGaijinProvider() {
//        expect.oneCall(gaijinator, rawRef, "instantiate", type, NO_PARAMS);
//        subject.provide(Barbarian.class, NO_PARAMS);
//    }
}
