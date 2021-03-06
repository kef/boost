package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.gunge.type.BaseReference;
import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.nursery.spider.layer.Layers;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.ModifierTestUtil;
import au.net.netstorm.boost.spider.gaijin.Barbarian;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.onion.core.Onionizer;

// SUGGEST: Moving constructor call logic out of here into a delegate will make the test a LOT simpler.
public final class DefaultProviderEngineAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields, InjectableSubject {
    Implementation gaijin = new DefaultImplementation(Barbarian.class);
    Interface initMarker = new DefaultInterface(Constructable.class);
    ModifierTestUtil modifierTestUtil = new DefaultModifierTestUtil();
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    Object[] parameters = {"Hi", "There"};
    Constructable constructableMock;
    Instantiator instantiatorMock;
    BaseReference unresolvedMock;
    InjectorEngine injectorMock;
    Implementation providezMoi;
    ResolvedInstance wrapped;
    Onionizer onionizerMock;
    Implementation implDummy;
    ProviderEngine subject;
    Object[] noParams = {};
    Layers proxiesMock;
    Object rawRef;

    public void setUpFixtures() {
        subject = new DefaultProviderEngine(onionizerMock, injectorMock, instantiatorMock, proxiesMock);
    }

    public void testProvider() {
        checkProvider(false);
        checkProvider(true);
    }

    private void checkProvider(boolean construct) {
        check(construct, parameters);
    }

    private void check(boolean construct, Object[] parameters) {
        expectations(construct, parameters);
        ResolvedInstance result = subject.provide(providezMoi, parameters);
        assertEquals(wrapped, result);
    }

    private void expectConstruct() {
        fielder.setInstance(providezMoi, "impl", NeedsConstructorChange.class);
        expect.oneCall(unresolvedMock, constructableMock, "getRef");
        expect.oneCall(constructableMock, VOID, "constructor");
    }

    private void expectations(boolean construct, Object[] parameters) {
        expect.oneCall(proxiesMock, false, "exists", providezMoi);
        expect.oneCall(instantiatorMock, unresolvedMock, "instantiate", providezMoi, parameters);
        expect.oneCall(injectorMock, VOID, "inject", unresolvedMock);
        expect.oneCall(onionizerMock, wrapped, "onionise", providezMoi, unresolvedMock);
        if (construct) expectConstruct();
    }
}
