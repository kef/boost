package au.net.netstorm.boost.pebble.create;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class ObjectInjectorAtomicTest extends InteractionTestCase {
    private Injector subject;
    private MockExpectations expect;
    private Injector creatorInjector;
    private Injector dependencyInjector;
    private Object ref;

    public void setupSubjects() {
        subject = new ObjectInjector(creatorInjector, dependencyInjector);
    }

    public void testAggregation() {
        expect.oneCall(creatorInjector, VOID, "inject", ref);
        expect.oneCall(dependencyInjector, VOID, "inject", ref);
        subject.inject(ref);
    }
}
