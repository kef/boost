package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultProviderAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    private static final Object SAND = new Sand();
    private static final Object[] PARAMETERS = {SAND};
    private static final Object[] NO_PARAMETERS = {};
    Provider subject;
    ProviderEngine engine;
    ResolvedInstance provided;
    Object ref;
    Implementation implementation = new DefaultImplementation(SmoothRock.class);

    public void setupSubjects() {
        subject = new DefaultProvider(engine);
    }

    public void testShortcut() {
        prepare(NO_PARAMETERS);
        Object result = subject.provide(SmoothRock.class);
        checkEquals(result);
    }

    public void testFull() {
        prepare(PARAMETERS);
        Object result = subject.provide(SmoothRock.class, PARAMETERS);
        checkEquals(result);
    }

    private void prepare(Object[] parameters) {
        expect.oneCall(engine, provided, "provide", implementation, parameters);
        expect.oneCall(provided, ref, "getRef");
    }

    private void checkEquals(Object result) {
        assertEquals(ref, result);
    }
}
