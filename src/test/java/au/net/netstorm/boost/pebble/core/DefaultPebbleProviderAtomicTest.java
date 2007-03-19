package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.type.DefaultImplementation;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultPebbleProviderAtomicTest extends InteractionTestCase {
    private static final Object SAND = new Sand();
    private static final Object[] PARAMETERS = {SAND};
    private PebbleProvider subject;
    private PebbleProviderEngine engine;
    private Object provided;
    private Implementation implementation = new DefaultImplementation(SmoothRock.class);

    public void testMapping() {
        expect.oneCall(engine, provided, "provide", implementation, PARAMETERS);
        Object result = subject.provide(SmoothRock.class, PARAMETERS);
        assertEquals(provided, result);
    }

    public void setupSubjects() {
        subject = new DefaultPebbleProvider(engine);
    }
}
