package au.net.netstorm.boost.time.core;

import junit.framework.TestCase;

import java.util.Date;

public final class TimePointAtomicTest extends TestCase {
    private static final TimeRangeMaster TIME_RANGE_MASTER = new DefaultTimeRangeMaster();
    private static final Object NULL = null;

    public void testEpoch() {
        assertEquals(0L, TimePoint.EPOCH.millis);
    }

    public void testArmaggedon() {
        assertEquals(Long.MAX_VALUE, TimePoint.ARMAGGEDON.millis);
    }

    public void testInvalidTimePoints() {
        assertInvalidTimePoints(TimePoint.EPOCH.millis - 1);
        assertInvalidTimePoints(Long.MIN_VALUE);
    }

    public void testValidTimePoints() {
        assertValidTimePoints(TimePoint.EPOCH.millis);
        assertValidTimePoints(TimePoint.EPOCH.millis + 1);
        assertValidTimePoints(TimePoint.EPOCH.millis + 100);
        assertValidTimePoints(Long.MAX_VALUE);
    }

    public void testEquality() {
        TimePoint time = new TimePoint(500);
        assertFalse(time.equals(NULL));
        assertFalse(time.equals(void.class));
        assertNotEquals(time, new TimePoint(499));
        assertEquals(time, new TimePoint(500));
    }

    public void testHashCode() {
        assertHashCode(500, new TimePoint(500));
        assertHashCode(499, new TimePoint(499));
        assertHashCode(1, new TimePoint(0x7FFFFFFF00000001L));
    }

    public void testCurrent() {
        long reference = new Date().getTime();
        TimePoint bottom = new TimePoint(reference - LEEWAY);
        TimePoint top = new TimePoint(reference + LEEWAY);
        TimePoint now = TimePoint.now();
        StartTime start = new StartTime(bottom);
        EndTime end = new EndTime(top);
        // FIX SC777 Tests TimeRange rather than TimePoint - move or delete.
        TimeRange range = new DefaultTimeRange(start, TIME_RANGE_MASTER.duration(start, end));
        assertTrue(range.contains(now));
    }

    private void assertInvalidTimePoints(long length) {
        try {
            new TimePoint(length);
            fail();
        } catch (IllegalArgumentException ex) { succeed(); } // FIX SC777 Fix others to call succeed().
    }

    // FIX SC777 Push up into a PrimordialTestCase.
    private void succeed() {
        assertTrue(true);
    }

    private void assertNotEquals(TimePoint t1, TimePoint t2) {
        assertFalse(t1.equals(t2));
        assertFalse(t2.equals(t1));
    }

    private void assertHashCode(int hash, TimePoint time) {
        assertEquals(hash, time.hashCode());
    }

    private void assertValidTimePoints(long length) {
        assertEquals(length, new TimePoint(length).millis);
    }

    private static final long LEEWAY = 5000;
}

