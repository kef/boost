package au.net.netstorm.boost.bullet.time.core;

import au.net.netstorm.boost.sniper.core.BoooostCase;// FIX SC507 Remove duplication between this class and StartTimeTest.

// FIX SC507 Primordialize.

public final class EndTimeAtomicTest extends BoooostCase {
    public void testNullInvalidInConstructor() {
        try {
            new EndTime(null);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    public void testValue() {
        assertEquals(TIME_499, new EndTime(TIME_499).point);
        assertEquals(TIME_500, new EndTime(TIME_500).point);
    }

    public void testEquality() {
        EndTime end = new EndTime(TIME_500);
        assertEquals(false, end.equals(null));
        assertEquals(false, end.equals(void.class));
        assertNotEquals(end, new EndTime(TIME_499));
        assertEquals(end, new EndTime(TIME_500));
    }

    public void testHashCode() {
        assertHashCode(500, new EndTime(TIME_500));
        assertHashCode(499, new EndTime(TIME_499));
        assertHashCode(1, new EndTime(TIME_0X7FFFFFFF00000001));
    }

    private void assertNotEquals(EndTime e1, EndTime e2) {
        assertEquals(false, e1.equals(e2));
        assertEquals(false, e2.equals(e1));
    }

    private void assertHashCode(int hash, EndTime end) {
        assertEquals(hash, end.hashCode());
    }

    private static final TimePoint TIME_500 = new DefaultTimePoint(500L);
    private static final TimePoint TIME_499 = new DefaultTimePoint(499L);
    private static final TimePoint TIME_0X7FFFFFFF00000001 = new DefaultTimePoint(0x7FFFFFFF00000001L);
}

