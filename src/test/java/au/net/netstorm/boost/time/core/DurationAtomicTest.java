package au.net.netstorm.boost.time.core;

import junit.framework.Assert;
import junit.framework.TestCase;

public final class DurationAtomicTest extends TestCase {

    public void testFields() {
        Assert.assertEquals(new Duration(1L), Duration.QUANTUM);
    }

    public void testInvalidDurations() {
        assertInvalidDurations(0L);
        assertInvalidDurations(-1L);
        assertInvalidDurations(Long.MIN_VALUE);
    }

    public void testValidDurations() {
        assertValidDurations(1L);
        assertValidDurations(100L);
        assertValidDurations(Long.MAX_VALUE);
    }

    public void testEquality() {
        Duration duration = new Duration(1000);
        assertFalse(duration.equals(null));
        assertFalse(duration.equals(void.class));
        assertNotEquals(duration, new Duration(1001));
        assertEquals(duration, new Duration(1000));
    }

    public void testHashCode() {
        assertHashCode(500, new Duration(500));
        assertHashCode(499, new Duration(499));
        assertHashCode(1, new Duration(0x7FFFFFFF00000001L));
    }

    private void assertInvalidDurations(long length) {
        try {
            new Duration(length);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    private void assertNotEquals(Duration d1, Duration d2) {
        assertFalse(d1.equals(d2));
        assertFalse(d2.equals(d1));
    }

    private void assertHashCode(int hash, Duration duration) {
        assertEquals(hash, duration.hashCode());
    }

    private void assertValidDurations(long length) {
        assertEquals(length, new Duration(length).millis);
    }
}

