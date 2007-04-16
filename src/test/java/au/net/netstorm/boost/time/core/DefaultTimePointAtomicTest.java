package au.net.netstorm.boost.time.core;

import java.util.Date;
import au.net.netstorm.boost.test.cases.BoooostCase;

// DEBT ClassDataAbstractionCoupling {
public final class DefaultTimePointAtomicTest extends BoooostCase {
    private static final TimeRangeMaster TIME_RANGE_MASTER = new DefaultTimeRangeMaster();
    private static final Object NULL = null;

    public void testEpoch() {
        assertEquals(0L, DefaultTimePoint.EPOCH.getMillis());
    }

    public void testArmaggedon() {
        assertEquals(Long.MAX_VALUE, DefaultTimePoint.ARMAGGEDON.getMillis());
    }

    public void testInvalidTimePoints() {
        assertInvalidTimePoints(DefaultTimePoint.EPOCH.getMillis() - 1);
        assertInvalidTimePoints(Long.MIN_VALUE);
    }

    public void testValidTimePoints() {
        assertValidTimePoints(DefaultTimePoint.EPOCH.getMillis());
        assertValidTimePoints(DefaultTimePoint.EPOCH.getMillis() + 1);
        assertValidTimePoints(DefaultTimePoint.EPOCH.getMillis() + 100);
        assertValidTimePoints(Long.MAX_VALUE);
    }

    public void testEquality() {
        TimePoint time = new DefaultTimePoint(500);
        assertEquals(false, time.equals(NULL));
        assertEquals(false, time.equals(void.class));
        assertNotEquals(time, new DefaultTimePoint(499));
        assertEquals(time, new DefaultTimePoint(500));
    }

    public void testHashCode() {
        assertHashCode(500, new DefaultTimePoint(500));
        assertHashCode(499, new DefaultTimePoint(499));
        assertHashCode(1, new DefaultTimePoint(0x7FFFFFFF00000001L));
    }

    public void testCurrent() {
        long reference = new Date().getTime();
        TimePoint bottom = new DefaultTimePoint(reference - LEEWAY);
        TimePoint top = new DefaultTimePoint(reference + LEEWAY);
        TimePoint now = DefaultTimePoint.now();
        StartTime start = new StartTime(bottom);
        EndTime end = new EndTime(top);
        // FIX SC777 Tests TimeRange rather than TimePoint - move or delete.
        TimeRange range = new DefaultTimeRange(start, TIME_RANGE_MASTER.duration(start, end));
        assertEquals(true, range.contains(now));
    }

    private void assertInvalidTimePoints(long length) {
        try {
            new DefaultTimePoint(length);
            fail();
        } catch (IllegalArgumentException ex) {
            succeed();
        } // FIX SC777 Fix others to call succeed().
    }

    // FIX SC777 Push up into a PrimordialTestCase.
    private void succeed() {
        assert (true);
    }

    private void assertNotEquals(TimePoint t1, TimePoint t2) {
        assertEquals(false, t1.equals(t2));
        assertEquals(false, t2.equals(t1));
    }

    private void assertHashCode(int hash, TimePoint time) {
        assertEquals(hash, time.hashCode());
    }

    private void assertValidTimePoints(long length) {
        assertEquals(length, new DefaultTimePoint(length).getMillis());
    }

    private static final long LEEWAY = 5000;
}
// } DEBT ClassDataAbstractionCoupling
