package au.net.netstorm.boost.time.core;

import junit.framework.TestCase;

// FIXME: SC507 Remove duplication between this class and StartTimeTest.
// FIXME: SC507 Primordialize.
public final class EndTimeAtomicTest extends TestCase {

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
        assertFalse(end.equals(null));
        assertFalse(end.equals(void.class));
        assertNotEquals(end, new EndTime(TIME_499));
        assertEquals(end, new EndTime(TIME_500));
    }

    public void testHashCode() {
        assertHashCode(500, new EndTime(TIME_500));
        assertHashCode(499, new EndTime(TIME_499));
        assertHashCode(1, new EndTime(TIME_0x7FFFFFFF00000001));
    }

    private void assertNotEquals(EndTime e1, EndTime e2) {
        assertFalse(e1.equals(e2));
        assertFalse(e2.equals(e1));
    }

    private void assertHashCode(int hash, EndTime end) {
        assertEquals(hash, end.hashCode());
    }

    private static final TimePoint TIME_500 = new TimePoint(500);
    private static final TimePoint TIME_499 = new TimePoint(499);
    private static final TimePoint TIME_0x7FFFFFFF00000001 = new TimePoint(0x7FFFFFFF00000001L);
}

