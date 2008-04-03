package au.net.netstorm.boost.time.type;

import au.net.netstorm.boost.gunge.core.BoooostCase;

public final class DayInMonthAtomicTest extends BoooostCase {
    public void testNullsInvalidInConstructor() {
        try {
            new DayInMonth(0, null);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    public void testConstants() {
        assertEquals(DayInMonth.FIRST_DAY_OF_YEAR, new DayInMonth(0, MonthOfYear.JANUARY));
    }

    // DEBT JavaNCSS {
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
// } DEBT JavaNCSS

    public void testFields() {
        assertFields(0, MonthOfYear.JANUARY);
        assertFields(30, MonthOfYear.JANUARY);
        assertFields(0, MonthOfYear.FEBRUARY);
        assertFields(28, MonthOfYear.FEBRUARY);
        assertFields(4, MonthOfYear.FEBRUARY);
        assertFields(0, MonthOfYear.DECEMBER);
        assertFields(30, MonthOfYear.DECEMBER);
    }

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
}

