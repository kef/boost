package au.net.netstorm.boost.time.type;

import junit.framework.TestCase;

public final class MonthOfYearAtomicTest extends TestCase {

    public void testMonthOfYear() {
        assertEquals(12, MonthOfYear.MONTHS_IN_YEAR);
    }

    public void testInvalidMonth() {
        assertInvalidMonth(-1);
        assertInvalidMonth(12);
    }

    public void testMonths() {
        for (int i=0; i < MonthOfYear.MONTHS_IN_YEAR; i++) {
            assertEquals(i, new MonthOfYear(i).value);
        }
    }

    public void testMaximumDays() {
        assertEquals(31, MonthOfYear.JANUARY.maxDays);
        assertEquals(29, MonthOfYear.FEBRUARY.maxDays);
        assertEquals(31, MonthOfYear.MARCH.maxDays);
        assertEquals(30, MonthOfYear.APRIL.maxDays);
        assertEquals(31, MonthOfYear.MAY.maxDays);
        assertEquals(30, MonthOfYear.JUNE.maxDays);
        assertEquals(31, MonthOfYear.JULY.maxDays);
        assertEquals(31, MonthOfYear.AUGUST.maxDays);
        assertEquals(30, MonthOfYear.SEPTEMBER.maxDays);
        assertEquals(31, MonthOfYear.OCTOBER.maxDays);
        assertEquals(30, MonthOfYear.NOVEMBER.maxDays);
        assertEquals(31, MonthOfYear.DECEMBER.maxDays);
    }

    public void testConstants() {
        assertEquals(new MonthOfYear(0) , MonthOfYear.JANUARY);
        assertEquals(new MonthOfYear(1) , MonthOfYear.FEBRUARY);
        assertEquals(new MonthOfYear(2) , MonthOfYear.MARCH);
        assertEquals(new MonthOfYear(3) , MonthOfYear.APRIL);
        assertEquals(new MonthOfYear(4) , MonthOfYear.MAY);
        assertEquals(new MonthOfYear(5) , MonthOfYear.JUNE);
        assertEquals(new MonthOfYear(6) , MonthOfYear.JULY);
        assertEquals(new MonthOfYear(7) , MonthOfYear.AUGUST);
        assertEquals(new MonthOfYear(8) , MonthOfYear.SEPTEMBER);
        assertEquals(new MonthOfYear(9) , MonthOfYear.OCTOBER);
        assertEquals(new MonthOfYear(10) , MonthOfYear.NOVEMBER);
        assertEquals(new MonthOfYear(11) , MonthOfYear.DECEMBER);
    }

    public void testEquality() {
        MonthOfYear month = new MonthOfYear(4);
        assertFalse(month.equals(null));
        assertFalse(month.equals(void.class));
        assertNotEquals(month, new MonthOfYear(7));
        assertEquals(month, new MonthOfYear(4));
    }

    public void testHashCode() {
        assertEquals(100, new MonthOfYear(2).hashCode());
    }

    // ---------- PRIVATE:

    private void assertNotEquals(MonthOfYear m1, MonthOfYear m2) {
        assertFalse(m1.equals(m2));
        assertFalse(m2.equals(m1));
    }

    private void assertInvalidMonth(int month) {
        try {
            new MonthOfYear(month);
            fail();
        } catch (IllegalArgumentException ex) { }
    }
}
