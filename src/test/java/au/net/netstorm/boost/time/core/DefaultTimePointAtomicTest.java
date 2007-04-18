package au.net.netstorm.boost.time.core;

import au.net.netstorm.boost.test.cases.BoooostCase;

// DEBT ClassDataAbstractionCoupling {
public final class DefaultTimePointAtomicTest extends BoooostCase {
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
// } DEBT ClassDataAbstractionCoupling