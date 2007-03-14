package au.net.netstorm.boost.pebble.inject.newer.core;

import au.net.netstorm.boost.pebble.inject.resolver.core.ResolverInjector;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class DependencyInjectorAtomicTest extends InteractionTestCase {
    private Injector subject;
    private MockExpectations expect;
    private Object ref;

    public void setupSubjects() {
        subject = new ResolverInjector();
    }

    public void testInjectorDoesNotExplode() {
        subject.inject(ref);
    }
}