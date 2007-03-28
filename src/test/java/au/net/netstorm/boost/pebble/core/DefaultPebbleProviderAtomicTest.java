package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultPebbleProviderAtomicTest extends InteractionTestCase {
    private static final Object SAND = new Sand();
    private static final Object[] PARAMETERS = {SAND};
    Provider subject;
    PebbleProviderEngine engine;
    ResolvedInstance provided;
    Object ref;
    Implementation implementation = new DefaultImplementation(SmoothRock.class);

    public void testMapping() {
        expect.oneCall(engine, provided, "provide", implementation, PARAMETERS);
        expect.oneCall(provided, ref, "getRef");
        Object result = subject.provide(SmoothRock.class, PARAMETERS);
        assertEquals(ref, result);
    }

    public void setupSubjects() {
        subject = new DefaultProvider(engine);
    }
}
