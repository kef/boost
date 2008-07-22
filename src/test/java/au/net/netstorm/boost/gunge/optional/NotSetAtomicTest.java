package au.net.netstorm.boost.gunge.optional;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;

public final class NotSetAtomicTest extends LifecycleTestCase implements HasFixtures {
    private Optional<Object> subject;

    public void setUpFixtures() {
        subject = new NotSet<Object>();
    }

    public void testIsSet() {
        boolean actual = subject.isSet();
        assertEquals(false, actual);
    }

    public void testGet() {
        try {
            subject.get();
            fail();
        } catch (IllegalStateException expected) {}
    }
}
