package au.net.netstorm.boost.time.core;

import au.net.netstorm.boost.test.cases.BoooostCase;

public final class StartTimeAtomicTest extends BoooostCase {
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
        assertEquals(false, start.equals(null));
        assertEquals(false, start.equals(void.class));
        assertNotEquals(start, new StartTime(TIME_499));
        assertEquals(start, new StartTime(new DefaultTimePoint(500)));
    }

    public void testHashCode() {
        assertHashCode(500, new StartTime(TIME_500));
        assertHashCode(499, new StartTime(TIME_499));
        assertHashCode(1, new StartTime(TIME_0X7FFFFFFF00000001));
    }

    private void assertNotEquals(StartTime s1, StartTime s2) {
        assertEquals(false, s1.equals(s2));
        assertEquals(false, s2.equals(s1));
    }

    private void assertHashCode(int hash, StartTime start) {
        assertEquals(hash, start.hashCode());
    }

    private static final TimePoint TIME_500 = new DefaultTimePoint(500);
    private static final TimePoint TIME_499 = new DefaultTimePoint(499);
    private static final TimePoint TIME_0X7FFFFFFF00000001 = new DefaultTimePoint(0x7FFFFFFF00000001L);
}

