package au.net.netstorm.boost.gunge.optional;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class DefaultOptionalAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest {
    private Optional<Object> subject;
    private Object dummy = new Object();

    public void setUpFixtures() {
        subject = new DefaultOptional<Object>(dummy);
    }

    public void testBlowUpOnNull() {
        try {
            new DefaultOptional(null);
            fail();
        } catch (IllegalArgumentException expected) {}
    }

    public void testIsSet() {
        boolean actual = subject.isSet();
        assertEquals(true, actual);
    }

    public void testGet() {
        Object actual = subject.get();
        assertSame(dummy, actual);
    }
}
