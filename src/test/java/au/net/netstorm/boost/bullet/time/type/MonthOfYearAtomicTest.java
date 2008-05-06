package au.net.netstorm.boost.bullet.time.type;

import au.net.netstorm.boost.sniper.core.BoooostCase;

public final class MonthOfYearAtomicTest extends BoooostCase {
    private static final MonthOfYear JANUARY = MonthOfYear.JANUARY;
    private static final MonthOfYear FEBRUARY = MonthOfYear.FEBRUARY;
    private static final MonthOfYear MARCH = MonthOfYear.MARCH;
    private static final MonthOfYear APRIL = MonthOfYear.APRIL;
    private static final MonthOfYear MAY = MonthOfYear.MAY;
    private static final MonthOfYear JUNE = MonthOfYear.JUNE;
    private static final MonthOfYear JULY = MonthOfYear.JULY;
    private static final MonthOfYear AUGUST = MonthOfYear.AUGUST;
    private static final MonthOfYear SEPTEMBER = MonthOfYear.SEPTEMBER;
    private static final MonthOfYear OCTOBER = MonthOfYear.OCTOBER;
    private static final MonthOfYear NOVEMBER = MonthOfYear.NOVEMBER;
    private static final MonthOfYear DECEMBER = MonthOfYear.DECEMBER;
    private static final Object NULL = null;

    public void testMonthOfYear() {
        assertEquals(12, MonthOfYear.MONTHS_IN_YEAR);
    }

    public void testInvalidMonth() {
        assertInvalidMonth(-1);
        assertInvalidMonth(12);
    }

    public void testMonths() {
        for (int i = 0; i < MonthOfYear.MONTHS_IN_YEAR; i++) {
            assertEquals(i, new MonthOfYear(i).value);
        }
    }

    // DEBT JavaNCSS {
    public void testMaximumDays() {
        assertEquals(31, JANUARY.maxDays);
        assertEquals(29, FEBRUARY.maxDays);
        assertEquals(31, MARCH.maxDays);
        assertEquals(30, APRIL.maxDays);
        assertEquals(31, MAY.maxDays);
        assertEquals(30, JUNE.maxDays);
        assertEquals(31, JULY.maxDays);
        assertEquals(31, AUGUST.maxDays);
        assertEquals(30, SEPTEMBER.maxDays);
        assertEquals(31, OCTOBER.maxDays);
        assertEquals(30, NOVEMBER.maxDays);
        assertEquals(31, DECEMBER.maxDays);
    }
// } DEBT JavaNCSS

    // DEBT JavaNCSS {

    public void testConstants() {
        assertEquals(new MonthOfYear(0), JANUARY);
        assertEquals(new MonthOfYear(1), FEBRUARY);
        assertEquals(new MonthOfYear(2), MARCH);
        assertEquals(new MonthOfYear(3), APRIL);
        assertEquals(new MonthOfYear(4), MAY);
        assertEquals(new MonthOfYear(5), JUNE);
        assertEquals(new MonthOfYear(6), JULY);
        assertEquals(new MonthOfYear(7), AUGUST);
        assertEquals(new MonthOfYear(8), SEPTEMBER);
        assertEquals(new MonthOfYear(9), OCTOBER);
        assertEquals(new MonthOfYear(10), NOVEMBER);
        assertEquals(new MonthOfYear(11), DECEMBER);
    }
// } DEBT JavaNCSS

    public void testEquality() {
        MonthOfYear month = new MonthOfYear(4);
        assertEquals(false, month.equals(NULL));
        assertEquals(false, month.equals(void.class));
        assertNotEquals(month, new MonthOfYear(7));
        assertEquals(month, new MonthOfYear(4));
    }

    public void testHashCode() {
        assertEquals(100, new MonthOfYear(2).hashCode());
    }

    // DEBT JavaNCSS {
    public void testToString() {
        assertToString("Jan", JANUARY);
        assertToString("Feb", FEBRUARY);
        assertToString("Mar", MARCH);
        assertToString("Apr", APRIL);
        assertToString("May", MAY);
        assertToString("Jun", JUNE);
        assertToString("Jul", JULY);
        assertToString("Aug", AUGUST);
        assertToString("Sep", SEPTEMBER);
        assertToString("Oct", OCTOBER);
        assertToString("Nov", NOVEMBER);
        assertToString("Dec", DECEMBER);
    }
// } DEBT JavaNCSS

    private void assertToString(String expected, MonthOfYear month) {
        assertEquals(expected, month.toString());
    }

    private void assertNotEquals(MonthOfYear m1, MonthOfYear m2) {
        assertEquals(false, m1.equals(m2));
        assertEquals(false, m2.equals(m1));
    }

    private void assertInvalidMonth(int month) {
        try {
            new MonthOfYear(month);
            fail();
        } catch (IllegalArgumentException ex) { }
    }
}
