package au.net.netstorm.boost.time.type;

import java.util.Calendar;

import junit.framework.TestCase;

public final class DaySpecAtomicTest extends TestCase {

    public void testValidDays() {
        final MonthSpec month = APRIL_2004;
        assertValid(month, 0);
        assertValid(month, month.totalDays-1);
    }

    public void testInvalidDays() {
        final MonthSpec month = APRIL_2004;
        assertInvalid(month, -1);
        assertInvalid(month, month.totalDays);
    }

    public void testEquality() {
        assertEquals(DAY_00_NOVEMBER_2004, getDaySpec(NOVEMBER_2004, 0));
        assertEquals(DAY_00_DECEMBER_2004, getDaySpec(DECEMBER_2004, 0));
        assertEquals(DAY_30_DECEMBER_2004, getDaySpec(DECEMBER_2004, 30));
    }

    public void testHashCode() {
        assertHashCode(DAY_00_NOVEMBER_2004, getDaySpec(NOVEMBER_2004, 0));
        assertHashCode(DAY_00_NOVEMBER_2004, getDaySpec(NOVEMBER_2004, 0));
        assertHashCode(DAY_00_DECEMBER_2004, getDaySpec(DECEMBER_2004, 0));
        assertHashCode(DAY_30_DECEMBER_2004, getDaySpec(DECEMBER_2004, 30));
    }

    public void testInEquality() {
        assertNotEquals(DAY_00_NOVEMBER_2004, getDaySpec(NOVEMBER_2004, 1));
        assertNotEquals(DAY_00_NOVEMBER_2004, getDaySpec(DECEMBER_2004, 0));
        assertNotEquals(DAY_00_NOVEMBER_2004, getDaySpec(OCTOBER_2004, 0));
        assertNotEquals(DAY_00_NOVEMBER_2004, getDaySpec(NOVEMBER_2005, 0));
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
        assertCompare(APRIL_2004, 29, MAY_2004, 00, LESS_THAN);
        assertCompare(MAY_2004, 00, APRIL_2004, 29, GREATER_THAN);
        assertCompare(APRIL_2006, 00, JANUARY_2006, 00, GREATER_THAN);
        assertCompare(JANUARY_2006, 00, APRIL_2006, 00, LESS_THAN);
    }

    public void testCompareYearDifferences() {
        assertCompare(APRIL_2006, 00, APRIL_2004, 00, GREATER_THAN);
        assertCompare(APRIL_2004, 00, APRIL_2006, 00, LESS_THAN);
        assertCompare(JANUARY_2006, 00, APRIL_2004, 00, GREATER_THAN);
        assertCompare(MAY_2004, 00, APRIL_2006, 00, LESS_THAN);

        assertCompare(DECEMBER_2004, 30, JANUARY_2005, 00, LESS_THAN);
    }

    // ------------ PRIVATE:

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

    private void assertCompare(MonthSpec month, int dayOffset, MonthSpec toMonth, int toDayOffset, int status) {
        DaySpec spec = new DaySpec(month, dayOffset);
        DaySpec toSpec = new DaySpec(toMonth, toDayOffset);
        assertEquals(status, spec.compareTo(toSpec));
    }

    private void assertNotEquals(DaySpec d1, DaySpec d2) {
        if (d1.equals(d2)) fail();
    }

    private void assertHashCode(DaySpec d1, DaySpec d2) {
        assertEquals(d1.hashCode(), d2.hashCode());
    }

    private static DaySpec getDaySpec(MonthSpec spec, int offset) {
        return new DaySpec(spec, offset);
    }

    private static final MonthSpec APRIL_2004 = new MonthSpec(2004, Calendar.APRIL);
    private static final MonthSpec MAY_2004 = new MonthSpec(2004, Calendar.MAY);
    private static final MonthSpec OCTOBER_2004 = new MonthSpec(2004, Calendar.OCTOBER);
    private static final MonthSpec NOVEMBER_2004 = new MonthSpec(2004, Calendar.NOVEMBER);
    private static final MonthSpec DECEMBER_2004 = new MonthSpec(2004, Calendar.DECEMBER);
    private static final MonthSpec JANUARY_2005 = new MonthSpec(2005, Calendar.JANUARY);
    private static final MonthSpec NOVEMBER_2005 = new MonthSpec(2005, Calendar.NOVEMBER);
    private static final MonthSpec APRIL_2006 = new MonthSpec(2006, Calendar.APRIL);
    private static final MonthSpec JANUARY_2006 = new MonthSpec(2006, Calendar.JANUARY);

    private static final DaySpec DAY_00_NOVEMBER_2004 = new DaySpec(NOVEMBER_2004, 0);
    private static final DaySpec DAY_00_DECEMBER_2004 = new DaySpec(DECEMBER_2004, 0);
    private static final DaySpec DAY_30_DECEMBER_2004 = new DaySpec(DECEMBER_2004, 30);

    private static final int EQUAL_TO = 0;
    private static final int LESS_THAN = -1;
    private static final int GREATER_THAN = 1;
}
