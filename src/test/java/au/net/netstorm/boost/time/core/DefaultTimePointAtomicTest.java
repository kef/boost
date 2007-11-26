package au.net.netstorm.boost.time.core;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.Long.MAX_VALUE;
import static java.lang.Long.MIN_VALUE;
import au.net.netstorm.boost.test.core.BoooostCase;
import static au.net.netstorm.boost.time.core.DefaultTimePoint.ARMAGEDDON;
import static au.net.netstorm.boost.time.core.DefaultTimePoint.EPOCH;

// FIX 8888 De-train wreck.
public final class DefaultTimePointAtomicTest extends BoooostCase {
    private static final Object NULL = null;
    private TimePoint a;
    private TimePoint b;

    protected void gearup() {
        a = new DefaultTimePoint(0L);
        b = new DefaultTimePoint(1L);
    }

    public void testEpoch() {
        Long millis = EPOCH.getMillis();
        assertEquals(0L, millis.longValue());
    }

    public void testArmaggedon() {
        Long millis = ARMAGEDDON.getMillis();
        assertEquals(MAX_VALUE, millis.longValue());
    }

    public void testInvalidTimePoints() {
        assertInvalidTimePoints(EPOCH.getMillis() - 1);
        assertInvalidTimePoints(MIN_VALUE);
    }

    public void testValidTimePoints() {
        assertValidTimePoints(EPOCH.getMillis());
        assertValidTimePoints(EPOCH.getMillis() + 1);
        assertValidTimePoints(EPOCH.getMillis() + 100);
        assertValidTimePoints(MAX_VALUE);
    }

    public void testEquality() {
        TimePoint time = new DefaultTimePoint(1L);
        assertEquals(false, time.equals(NULL));
        assertEquals(false, time.equals(void.class));
        assertNotEquals(time, a);
        assertEquals(time, b);
    }

    public void testHashCode() {
        assertHashCode(0, a);
        assertHashCode(500, new DefaultTimePoint(500L));
        assertHashCode(1, new DefaultTimePoint(0x7FFFFFFF00000001L));
    }

    public void testComparable() {
        checkCompareChecksType(a);
        checkCompare(a, b, -1);
        checkCompare(b, a, 1);
        checkCompare(a, a, 0);
    }

    public void testBefore() {
        assertEquals(TRUE, a.before(b));
        assertEquals(FALSE, b.before(a));
        assertEquals(FALSE, b.before(b));
    }

    public void testAfter() {
        assertEquals(FALSE, a.after(b));
        assertEquals(TRUE, b.after(a));
        assertEquals(FALSE, a.after(a));
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

    private void assertValidTimePoints(Long length) {
        TimePoint timePoint = new DefaultTimePoint(length);
        Long millis = timePoint.getMillis();
        assertEquals(length, millis);
    }
}
