package au.net.netstorm.boost.pebble.create;

import au.net.netstorm.boost.pebble.create.inject.Injector;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.onion.Onion;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;

public final class DefaultCreatorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private Creator subject;
    private MockExpectations expect;
    private Onion onion;
    private Instantiator instantiator;
    private Injector injector;
    private Object[] parameters = {"Hi", "There"};
    private Class type = String.class;
    private Object rawRef = new Object();
    private Object wrappedRef = new Object();

    public void setupSubjects() {
        subject = new DefaultCreator(onion, injector, instantiator);
    }

    public void testCreator() {
        expect.oneCall(instantiator, rawRef, "instantiate", type, parameters);
        expect.oneCall(injector, VOID, "inject", rawRef);
        expect.oneCall(onion, wrappedRef, "onionize", rawRef);
        Object result = subject.create(type, parameters);
        assertEquals(wrappedRef, result);
    }
}
