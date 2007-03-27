package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class PebbleInjectorAtomicTest extends InteractionTestCase {
    Injector subject;
    Injector newerInjector;
    Injector dependencyInjector;
    UnresolvedInstance unresolved;

    public void setupSubjects() {
        subject = new PebbleInjector(newerInjector, dependencyInjector);
    }

    public void testAggregation() {
        expect.oneCall(newerInjector, VOID, "inject", unresolved);
        expect.oneCall(dependencyInjector, VOID, "inject", unresolved);
        subject.inject(unresolved);
    }
}
