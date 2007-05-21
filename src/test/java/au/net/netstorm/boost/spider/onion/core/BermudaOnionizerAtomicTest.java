package au.net.netstorm.boost.spider.onion.core;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.BaseReference;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class BermudaOnionizerAtomicTest extends InteractionTestCase implements HasSubjects {
    Onionizer subject;
    BaseReference resolved;

    public void setupSubjects() {
        subject = new BermudaOnionizer();
    }

    public void testOnionize() {
        ResolvedInstance instance = subject.onionise(resolved);
        assertEquals(resolved, instance);
    }
}
