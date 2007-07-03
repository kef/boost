package au.net.netstorm.boost.time.core;

import au.net.netstorm.boost.test.core.BoooostCase;

public final class DefaultTimePointAtomicTest extends BoooostCase {
    private static final Object NULL = null;
    private TimePoint a;
    private TimePoint b;

    protected void gearup() {
        a = new DefaultTimePoint(0);
        b = new DefaultTimePoint(1);
    }

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
        TimePoint time = new DefaultTimePoint(1);
        assertEquals(false, time.equals(NULL));
        assertEquals(false, time.equals(void.class));
        assertNotEquals(time, a);
        assertEquals(time, b);
    }

    public void testHashCode() {
        assertHashCode(0, a);
        assertHashCode(500, new DefaultTimePoint(500));
        assertHashCode(1, new DefaultTimePoint(0x7FFFFFFF00000001L));
    }

    public void testComparable() {
        checkCompareChecksType(a);
        checkCompare(a, b, -1);
        checkCompare(b, a, 1);
        checkCompare(a, a, 0);
    }

    public void testBefore() {
        assertEquals(true, a.before(b));
        assertEquals(false, b.before(a));
        assertEquals(false, b.before(b));
    }

    public void testAfter() {
        assertEquals(false, a.after(b));
        assertEquals(true, b.after(a));
        assertEquals(false, a.after(a));
    }

    private void checkCompareChecksType(TimePoint a) {
        try {
            a.compareTo(new Object());
            fail();
        } catch (ClassCastException expected) { }
    }

    private void checkCompare(TimePoint a, TimePoint b, int expected) {
        int actual = a.compareTo(b);
        assertEquals(expected, actual);
    }

    private void assertInvalidTimePoints(long length) {
        try {
            new DefaultTimePoint(length);
            fail();
        } catch (IllegalArgumentException ex) { }
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
}
