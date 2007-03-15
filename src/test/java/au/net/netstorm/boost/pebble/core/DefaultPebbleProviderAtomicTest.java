package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.type.DefaultImplementation;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class DefaultPebbleProviderAtomicTest extends InteractionTestCase {
    private static final Object SAND = new Sand();
    private static final Object[] PARAMETERS = {SAND};
    private PebbleProvider subject;
    private MockExpectations expect;
    private NewPebbleProviderEngine engine;
    private Object provided;
    private Implementation implementation = new DefaultImplementation(SmoothRock.class);

    // FIX 1715 Expect field into interaction test case.
    // FIX BREADCRUMB 1715 Complete this.
    public void testMapping() {
        expect.oneCall(engine, provided, "provider", implementation, PARAMETERS);
        Object result = subject.provide(SmoothRock.class, PARAMETERS);
        // FIX 1715 Test return value.
    }

    public void setupSubjects() {
        subject = new DefaultPebbleProvider(engine);
    }
}
