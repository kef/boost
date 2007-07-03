package au.net.netstorm.boost.time.type;

import au.net.netstorm.boost.test.core.BoooostCase;

public final class DayInMonthUtilAtomicTest extends BoooostCase {
    private final DayInMonthMaster master = new DefaultDayInMonthMaster();

    public void testIncDecMonth() {
        assertIncDecMonth(JAN_00, FEB_00);
        assertIncDecMonth(JAN_01, FEB_01);
        assertIncDecMonth(JAN_02, FEB_02);
        assertIncDecMonth(JAN_28, FEB_28);
        assertIncDecMonth(FEB_00, MAR_00);
        assertIncDecMonth(DEC_00, JAN_00);
    }

    // DEBT JavaNCSS {
    public void testBoundaryDays() {
        assertEquals(FEB_28, master.incMonth(JAN_29));
        assertEquals(FEB_28, master.incMonth(JAN_30));
        assertEquals(APR_29, master.incMonth(MAR_30));
        assertEquals(JUN_29, master.incMonth(MAY_30));
        assertEquals(SEP_29, master.incMonth(AUG_30));
        assertEquals(NOV_29, master.incMonth(OCT_30));
        assertEquals(FEB_28, master.decMonth(MAR_29));
        assertEquals(FEB_28, master.decMonth(MAR_30));
        assertEquals(APR_29, master.decMonth(MAY_30));
        assertEquals(JUN_29, master.decMonth(JUL_30));
        assertEquals(SEP_29, master.decMonth(OCT_30));
        assertEquals(NOV_29, master.decMonth(DEC_30));
    }
// } DEBT JavaNCSS

    public void testIncDecDay() {
        assertIncDecDay(JAN_00, JAN_01);
        assertIncDecDay(JAN_01, JAN_02);
        assertIncDecDay(JAN_30, JAN_00);
        assertIncDecDay(FEB_00, FEB_01);
        assertIncDecDay(FEB_01, FEB_02);
        assertIncDecDay(FEB_28, FEB_00);
        assertIncDecDay(APR_00, APR_01);
        assertIncDecDay(APR_01, APR_02);
        assertIncDecDay(APR_29, APR_00);
    }

    private void assertIncDecDay(DayInMonth pre, DayInMonth post) {
        assertEquals(post, master.incDay(pre));
        assertEquals(pre, master.decDay(post));
    }

    private void assertIncDecMonth(DayInMonth pre, DayInMonth post) {
        assertEquals(post, master.incMonth(pre));
        assertEquals(pre, master.decMonth(post));
    }

    private static final DayInMonth JAN_00 = new DayInMonth(0, MonthOfYear.JANUARY);
    private static final DayInMonth JAN_01 = new DayInMonth(1, MonthOfYear.JANUARY);
    private static final DayInMonth JAN_02 = new DayInMonth(2, MonthOfYear.JANUARY);
    private static final DayInMonth JAN_28 = new DayInMonth(28, MonthOfYear.JANUARY);
    private static final DayInMonth JAN_29 = new DayInMonth(29, MonthOfYear.JANUARY);
    private static final DayInMonth JAN_30 = new DayInMonth(30, MonthOfYear.JANUARY);
    private static final DayInMonth FEB_00 = new DayInMonth(0, MonthOfYear.FEBRUARY);
    private static final DayInMonth FEB_01 = new DayInMonth(1, MonthOfYear.FEBRUARY);
    private static final DayInMonth FEB_02 = new DayInMonth(2, MonthOfYear.FEBRUARY);
    private static final DayInMonth FEB_28 = new DayInMonth(28, MonthOfYear.FEBRUARY);
    private static final DayInMonth MAR_00 = new DayInMonth(0, MonthOfYear.MARCH);
    private static final DayInMonth MAR_29 = new DayInMonth(29, MonthOfYear.MARCH);
    private static final DayInMonth MAR_30 = new DayInMonth(30, MonthOfYear.MARCH);
    private static final DayInMonth APR_00 = new DayInMonth(0, MonthOfYear.APRIL);
    private static final DayInMonth APR_01 = new DayInMonth(1, MonthOfYear.APRIL);
    private static final DayInMonth APR_02 = new DayInMonth(2, MonthOfYear.APRIL);
    private static final DayInMonth APR_29 = new DayInMonth(29, MonthOfYear.APRIL);
    private static final DayInMonth MAY_30 = new DayInMonth(30, MonthOfYear.MAY);
    private static final DayInMonth JUN_29 = new DayInMonth(29, MonthOfYear.JUNE);
    private static final DayInMonth JUL_30 = new DayInMonth(30, MonthOfYear.JULY);
    private static final DayInMonth AUG_30 = new DayInMonth(30, MonthOfYear.AUGUST);
    private static final DayInMonth SEP_29 = new DayInMonth(29, MonthOfYear.SEPTEMBER);
    private static final DayInMonth OCT_30 = new DayInMonth(30, MonthOfYear.OCTOBER);
    private static final DayInMonth NOV_29 = new DayInMonth(29, MonthOfYear.NOVEMBER);
    private static final DayInMonth DEC_00 = new DayInMonth(0, MonthOfYear.DECEMBER);
    private static final DayInMonth DEC_30 = new DayInMonth(30, MonthOfYear.DECEMBER);
}

