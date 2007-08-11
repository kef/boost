package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.newer.DefaultResolvedThings;
import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.spider.gaijin.Barbarian;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InjectableSubject;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.BaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultProviderEngineAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields, InjectableSubject {
    Object[] noParams = {};
    ProviderEngine subject;
    Onionizer onionizerMock;
    Instantiator instantiatorMock;
    InjectorEngine injectorMock;
    Object[] parameters = {"Hi", "There"};
    Implementation providezMoi;
    BaseReference unresolvedMock;
    Object rawRef;
    ResolvedInstance wrapped;
    Constructable constructableMock;
    Implementation gaijin = new DefaultImplementation(Barbarian.class);
    Interface initMarker = new DefaultInterface(Constructable.class);
    ResolvedThings resolvedThings = new DefaultResolvedThings();
    FieldTestUtil fielder = new DefaultFieldTestUtil();

    public void setUpFixtures() {
        subject = new DefaultProviderEngine(onionizerMock, injectorMock, instantiatorMock);
    }

    public void testProvider() {
        checkProvider(false);
        checkProvider(true);
    }

    private void checkProvider(boolean construct) {
        checkProvider(construct, parameters);
        doCheck(construct);
    }

    private void doCheck(boolean construct) {
        expectations(construct, noParams);
        subject.provide(providezMoi);
    }

    private void checkProvider(boolean construct, Object[] parameters) {
        expectations(construct, parameters);
        ResolvedInstance result = subject.provide(providezMoi, parameters);
        assertEquals(wrapped, result);
    }

    private void expectConstruct() {
        fielder.setInstance(providezMoi, "impl", ConstructableImpl.class);
        expect.oneCall(unresolvedMock, constructableMock, "getRef");
        expect.oneCall(constructableMock, MockExpectations.VOID, "constructor");
    }

    private void expectations(boolean construct, Object[] parameters) {
        resolvedThings.clear();
        expect.oneCall(instantiatorMock, unresolvedMock, "instantiate", providezMoi, parameters);
        expect.oneCall(injectorMock, MockExpectations.VOID, "inject", unresolvedMock);
        expect.oneCall(onionizerMock, wrapped, "onionise", providezMoi, unresolvedMock);
        if (construct) expectConstruct();
    }

    // FIX BREADCRUMB 2081 AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA.
    // FIX 2081 Move this out.
    // FIX 1887 Remove all inner classes.
    private static class ConstructableImpl implements Constructable {
        public void constructor() {
        }
    }
}
