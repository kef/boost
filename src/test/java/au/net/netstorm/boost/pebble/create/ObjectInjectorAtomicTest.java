package au.net.netstorm.boost.pebble.create;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class ObjectInjectorAtomicTest extends InteractionTestCase {
    private Injector subject;
    private MockExpectations expect;
    private Injector creatorInjector;
    private Injector resolverInjector;

    public void setupSubjects() {
        ObjectInjector subject = new ObjectInjector(creatorInjector, resolverInjector);
    }

    public void testAggregation() {
        // FIX 1715 Complete.
    }
}
