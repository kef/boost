package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class CitizenInjectorEngineAtomicTest extends InteractionTestCase {
    InjectorEngine subject;
    InjectorEngine dependencyInjector;
    UnresolvedInstance unresolved;

    public void setupSubjects() {
        subject = new CitizenInjectorEngine(dependencyInjector);
    }

    public void testAggregation() {
        expect.oneCall(dependencyInjector, VOID, "inject", unresolved);
        subject.inject(unresolved);
    }
}
