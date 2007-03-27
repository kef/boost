package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.inject.core.InjectorEngine;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class PebbleInjectorEngineAtomicTest extends InteractionTestCase {
    InjectorEngine subject;
    InjectorEngine newerInjector;
    InjectorEngine dependencyInjector;
    UnresolvedInstance unresolved;

    public void setupSubjects() {
        subject = new PebbleInjectorEngine(newerInjector, dependencyInjector);
    }

    public void testAggregation() {
        expect.oneCall(newerInjector, VOID, "inject", unresolved);
        expect.oneCall(dependencyInjector, VOID, "inject", unresolved);
        subject.inject(unresolved);
    }
}
