package au.net.netstorm.boost.pebble.inject.newer.inject;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class ObjectInjectorAtomicTest extends InteractionTestCase {
    private Injector subject;
    private MockExpectations expect;
    private Injector newerInjector;
    private Injector dependencyInjector;
    private Object ref;

    public void setupSubjects() {
        subject = new ObjectInjector(newerInjector, dependencyInjector);
    }

    public void testAggregation() {
        expect.oneCall(newerInjector, VOID, "inject", ref);
        expect.oneCall(dependencyInjector, VOID, "inject", ref);
        subject.inject(ref);
    }
}
