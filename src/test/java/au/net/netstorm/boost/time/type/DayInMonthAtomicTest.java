package au.net.netstorm.boost.time.type;

import junit.framework.TestCase;

public final class DayInMonthAtomicTest extends TestCase {

    public void testNullsInvalidInConstructor() {
        try {
            new DayInMonth(0, null);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    public void testConstants() {
        assertEquals(DayInMonth.FIRST_DAY_OF_YEAR, new DayInMonth(0, MonthOfYear.JANUARY));
    }

    public void testIllegalDay() {
        assertIllegalDay(31, MonthOfYear.JANUARY);
        assertIllegalDay(29, MonthOfYear.FEBRUARY);
        assertIllegalDay(31, MonthOfYear.MARCH);
        assertIllegalDay(30, MonthOfYear.APRIL);
        assertIllegalDay(31, MonthOfYear.MAY);
        assertIllegalDay(30, MonthOfYear.JUNE);
        assertIllegalDay(31, MonthOfYear.JULY);
        assertIllegalDay(31, MonthOfYear.AUGUST);
        assertIllegalDay(30, MonthOfYear.SEPTEMBER);
        assertIllegalDay(31, MonthOfYear.OCTOBER);
        assertIllegalDay(30, MonthOfYear.NOVEMBER);
        assertIllegalDay(31, MonthOfYear.DECEMBER);
    }

    public void testFields() {
        assertFields(0 , MonthOfYear.JANUARY);
        assertFields(30 , MonthOfYear.JANUARY);
        assertFields(0 , MonthOfYear.FEBRUARY);
        assertFields(28 , MonthOfYear.FEBRUARY);
        assertFields(4 , MonthOfYear.FEBRUARY);
        assertFields(0 , MonthOfYear.DECEMBER);
        assertFields(30 , MonthOfYear.DECEMBER);
    }

    public void testEquality() {
        final DayInMonth JAN_12 = new DayInMonth(12, MonthOfYear.JANUARY);
        assertFalse(JAN_12.equals(null));
        assertFalse(JAN_12.equals(void.class));
        assertNotEquals(JAN_12, new DayInMonth(11, JAN_12.month));
        assertNotEquals(JAN_12, new DayInMonth(JAN_12.day, MonthOfYear.FEBRUARY));
        assertEquals(JAN_12, new DayInMonth(12, MonthOfYear.JANUARY));
    }

    public void testHashCode() {
        assertEquals(100, new DayInMonth(1, MonthOfYear.JANUARY).hashCode());
    }

    // ---------- PRIVATE:

    private void assertFields(int day, MonthOfYear month) {
        DayInMonth dom = new DayInMonth(day, month);
        assertEquals(day, dom.day);
        assertEquals(month, dom.month);
    }

    private void assertIllegalDay(int day, MonthOfYear month) {
        try {
            new DayInMonth(day, month);
            fail();
        } catch (IllegalArgumentException ex) { }
        try {
            new DayInMonth(-1, month);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    private void assertNotEquals(DayInMonth d1, DayInMonth d2) {
        assertFalse(d1.equals(d2));
        assertFalse(d2.equals(d1));
    }
}

