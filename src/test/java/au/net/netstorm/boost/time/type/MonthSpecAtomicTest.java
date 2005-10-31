package au.net.netstorm.boost.time.type;

import java.util.Calendar;

import junit.framework.TestCase;

public final class MonthSpecAtomicTest extends TestCase {
    // FIXME: SC507 Check for other NULL in time.core.  This and it probably have a lot of duplication.
    // FIXME: SC507 Internal static per class is probably fine. 
    private static final Object NULL = null;

    public void testConstruction() {
        assertConstruction(2004, Calendar.JANUARY);
        assertConstruction(2004, Calendar.FEBRUARY);
        assertConstruction(1999, Calendar.JANUARY);
        assertConstruction(1999, Calendar.FEBRUARY);
        assertConstruction(1969, Calendar.OCTOBER);
        assertConstruction(1969, Calendar.DECEMBER);
    }

    public void testComparable() {
        assertCompare(2004, Calendar.FEBRUARY, 2004, Calendar.FEBRUARY, EQUAL_TO);
        assertCompare(2004, Calendar.FEBRUARY, 2004, Calendar.JANUARY, GREATER_THAN);
        assertCompare(2003, Calendar.FEBRUARY, 2004, Calendar.JANUARY, LESS_THAN);
        assertCompare(2004, Calendar.JANUARY, 2004, Calendar.FEBRUARY, LESS_THAN);
        assertCompare(2004, Calendar.JANUARY, 2003, Calendar.FEBRUARY, GREATER_THAN);
    }

    public void testComparableCheck() {
        MonthSpec m1 = new MonthSpec(2004, Calendar.JANUARY);
        m1.compareTo(m1);

        try {
            m1.compareTo("THIS AIN'T GONNA WORK");
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    public void testEquality() {
        MonthSpec month = new MonthSpec(2000, Calendar.JANUARY);
        assertFalse(month.equals(NULL));
        assertFalse(month.equals(void.class));
        assertNotEquals(month, new MonthSpec(2000, Calendar.FEBRUARY));
        assertNotEquals(month, new MonthSpec(2001, Calendar.JANUARY));
        assertEquals(month, new MonthSpec(2000, Calendar.JANUARY));
    }

    public void testDaysInMonth() {
        assertDaysInMonth(31, 2004, Calendar.JANUARY);
        assertDaysInMonth(31, 2004, Calendar.MARCH);
        assertDaysInMonth(30, 2004, Calendar.APRIL);
        assertDaysInMonth(31, 2004, Calendar.MAY);
        assertDaysInMonth(30, 2004, Calendar.JUNE);
        assertDaysInMonth(31, 2004, Calendar.JULY);
        assertDaysInMonth(31, 2004, Calendar.AUGUST);
        assertDaysInMonth(30, 2004, Calendar.SEPTEMBER);
        assertDaysInMonth(31, 2004, Calendar.OCTOBER);
        assertDaysInMonth(30, 2004, Calendar.NOVEMBER);
        assertDaysInMonth(31, 2004, Calendar.DECEMBER);

        // Leap years.
        assertDaysInMonth(29, 2004, Calendar.FEBRUARY);
        assertDaysInMonth(28, 2003, Calendar.FEBRUARY);
    }

    public void testOutOfRange() {
        try {
            new MonthSpec(2004, -1);
            fail();
        } catch (IllegalArgumentException ex) { }
        try {
            new MonthSpec(2004, 12);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    public void testStartDayOfWeek() {
        assertStartDay(Calendar.THURSDAY,  2004, Calendar.JANUARY);
        assertStartDay(Calendar.SUNDAY,    2004, Calendar.FEBRUARY);
        assertStartDay(Calendar.MONDAY,    2004, Calendar.MARCH);
        assertStartDay(Calendar.THURSDAY,  2004, Calendar.APRIL);
        assertStartDay(Calendar.SATURDAY,  2004, Calendar.MAY);
        assertStartDay(Calendar.TUESDAY,   2004, Calendar.JUNE);
        assertStartDay(Calendar.THURSDAY,  2004, Calendar.JULY);
        assertStartDay(Calendar.SUNDAY,    2004, Calendar.AUGUST);
        assertStartDay(Calendar.WEDNESDAY, 2004, Calendar.SEPTEMBER);
        assertStartDay(Calendar.FRIDAY,    2004, Calendar.OCTOBER);
        assertStartDay(Calendar.MONDAY,    2004, Calendar.NOVEMBER);
        assertStartDay(Calendar.WEDNESDAY, 2004, Calendar.DECEMBER);

        assertStartDay(Calendar.THURSDAY, 1999, Calendar.APRIL);
        assertStartDay(Calendar.SUNDAY,   2001, Calendar.APRIL);
        assertStartDay(Calendar.TUESDAY,  2003, Calendar.APRIL);
        assertStartDay(Calendar.THURSDAY, 2004, Calendar.APRIL);
        assertStartDay(Calendar.FRIDAY,   2005, Calendar.APRIL);
        assertStartDay(Calendar.SATURDAY, 2006, Calendar.APRIL);
        assertStartDay(Calendar.SUNDAY,   2007, Calendar.APRIL);
    }

    // PRIVATE:

    private void assertDaysInMonth(int expected, int year, int month) {
        MonthSpec spec = new MonthSpec(year, month);
        assertEquals(month, spec.month);
        assertEquals(expected, spec.totalDays);
    }

    private void assertStartDay(int expected, int year, int month){
        MonthSpec spec = new MonthSpec(year, month);
        assertEquals(expected, spec.startDay);
    }

    private void assertConstruction(int year, int month) {
        MonthSpec spec = new MonthSpec(year, month);
        assertEquals(year, spec.year);
        assertEquals(month, spec.month);
    }

    private void assertCompare(int year, int month, int toYear, int toMonth, int status) {
        MonthSpec spec = new MonthSpec(year, month);
        MonthSpec toSpec = new MonthSpec(toYear, toMonth);
        assertEquals(status, spec.compareTo(toSpec));
    }

    private void assertNotEquals(MonthSpec m1, MonthSpec m2) {
        assertFalse(m1.equals(m2));
        assertFalse(m2.equals(m1));
    }

    private static final int EQUAL_TO = 0;
    private static final int LESS_THAN = -1;
    private static final int GREATER_THAN = 1;
}
