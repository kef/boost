package au.net.netstorm.boost.spider.onion.core;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.BaseReference;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class BermudaOnionizerAtomicTest extends InteractionTestCase implements HasFixtures {
    Onionizer subject;
    BaseReference resolved;

    public void setUpFixtures() {
        subject = new BermudaOnionizer();
    }

    public void testOnionize() {
        ResolvedInstance instance = subject.onionise(resolved);
        assertEquals(resolved, instance);
    }
}
