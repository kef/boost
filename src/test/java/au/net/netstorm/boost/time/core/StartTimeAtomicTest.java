package au.net.netstorm.boost.time.core;

import junit.framework.TestCase;

public final class StartTimeAtomicTest extends TestCase {
    public void testNullInvalidInConstructor() {
        try {
            new StartTime(null);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    public void testValue() {
        assertEquals(TIME_499, new StartTime(TIME_499).point);
        assertEquals(TIME_500, new StartTime(TIME_500).point);
    }

    public void testEquality() {
        StartTime start = new StartTime(TIME_500);
        assertFalse(start.equals(null));
        assertFalse(start.equals(void.class));
        assertNotEquals(start, new StartTime(TIME_499));
        assertEquals(start, new StartTime(new TimePoint(500)));
    }

    public void testHashCode() {
        assertHashCode(500, new StartTime(TIME_500));
        assertHashCode(499, new StartTime(TIME_499));
        assertHashCode(1, new StartTime(TIME_0x7FFFFFFF00000001));
    }

    private void assertNotEquals(StartTime s1, StartTime s2) {
        assertFalse(s1.equals(s2));
        assertFalse(s2.equals(s1));
    }

    private void assertHashCode(int hash, StartTime start) {
        assertEquals(hash, start.hashCode());
    }

    private static final TimePoint TIME_500 = new TimePoint(500);
    private static final TimePoint TIME_499 = new TimePoint(499);
    private static final TimePoint TIME_0x7FFFFFFF00000001 = new TimePoint(0x7FFFFFFF00000001L);
}

