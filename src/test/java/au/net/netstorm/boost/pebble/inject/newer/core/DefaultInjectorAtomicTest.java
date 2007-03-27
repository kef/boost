package au.net.netstorm.boost.pebble.inject.newer.core;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

// FIX BREADCRUMB 32755 Back here and complete.
public final class DefaultInjectorAtomicTest extends InteractionTestCase {
    Injector subject;
    Object ref;

    public void setupSubjects() {
        subject = new DefaultInjector();
    }

    public void testInjector() {
        subject.inject(ref);
        // FIX BREADCRUMB 32755 Complete this.
    }
}
