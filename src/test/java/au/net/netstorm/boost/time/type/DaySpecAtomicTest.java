package au.net.netstorm.boost.time.type;

import junit.framework.TestCase;

import java.util.Calendar;

public final class DaySpecAtomicTest extends TestCase {
    public void testValidDays() {
        final MonthSpec month = APRIL_2004;
        assertValid(month, 0);
        assertValid(month, month.totalDays - 1);
    }

    public void testInvalidDays() {
        final MonthSpec month = APRIL_2004;
        assertInvalid(month, -1);
        assertInvalid(month, month.totalDays);
    }

    public void testComparableCheck() {
        DaySpec d1 = new DaySpec(APRIL_2004, 0);
        d1.compareTo(d1);
        try {
            d1.compareTo("THIS AIN'T GONNA WORK");
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    public void testCompareDaysWithMonth() {
        assertCompare(APRIL_2004, 10, APRIL_2004, 10, EQUAL_TO);
        assertCompare(APRIL_2004, 11, APRIL_2004, 10, GREATER_THAN);
        assertCompare(APRIL_2004, 10, APRIL_2004, 11, LESS_THAN);
    }

    public void testCompareMonthDifferences() {
        assertCompare(APRIL_2004, 29, MAY_2004, 0, LESS_THAN);
        assertCompare(MAY_2004, 0, APRIL_2004, 29, GREATER_THAN);
        assertCompare(APRIL_2006, 0, JANUARY_2006, 0, GREATER_THAN);
        assertCompare(JANUARY_2006, 0, APRIL_2006, 0, LESS_THAN);
    }

    public void testCompareYearDifferences() {
        assertCompare(APRIL_2006, 0, APRIL_2004, 0, GREATER_THAN);
        assertCompare(APRIL_2004, 0, APRIL_2006, 0, LESS_THAN);
        assertCompare(JANUARY_2006, 0, APRIL_2004, 0, GREATER_THAN);
        assertCompare(MAY_2004, 0, APRIL_2006, 0, LESS_THAN);
        assertCompare(DECEMBER_2004, 30, JANUARY_2005, 0, LESS_THAN);
    }

    private void assertValid(MonthSpec month, int day) {
        try {
            new DaySpec(month, day);
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    private void assertInvalid(MonthSpec month, int day) {
        try {
            new DaySpec(month, day);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

// DEBT ParameterNumber {
    private void assertCompare(MonthSpec month, int dayOffset, MonthSpec toMonth, int toDayOffset, int status) {
        DaySpec spec = new DaySpec(month, dayOffset);
        DaySpec toSpec = new DaySpec(toMonth, toDayOffset);
        assertEquals(status, spec.compareTo(toSpec));
    }
// } DEBT ParameterNumber

    private static final MonthSpec APRIL_2004 = new MonthSpec(2004, Calendar.APRIL);
    private static final MonthSpec MAY_2004 = new MonthSpec(2004, Calendar.MAY);
    private static final MonthSpec DECEMBER_2004 = new MonthSpec(2004, Calendar.DECEMBER);
    private static final MonthSpec JANUARY_2005 = new MonthSpec(2005, Calendar.JANUARY);
    private static final MonthSpec APRIL_2006 = new MonthSpec(2006, Calendar.APRIL);
    private static final MonthSpec JANUARY_2006 = new MonthSpec(2006, Calendar.JANUARY);
    private static final int EQUAL_TO = 0;
    private static final int LESS_THAN = -1;
    private static final int GREATER_THAN = 1;
}
