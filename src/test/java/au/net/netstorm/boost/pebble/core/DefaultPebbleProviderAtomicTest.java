package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class DefaultPebbleProviderAtomicTest extends InteractionTestCase {
    private PebbleProvider subject;
    private MockExpectations expect;
    private PebbleProviderEngine engine;

    // FIX 1715 Expect field into interaction test case.
    // FIX BREADCRUMB 1715 Complete this.
    public void testMapping() {
    }

    public void setupSubjects() {
        subject = new DefaultPebbleProvider(engine);
    }
}
