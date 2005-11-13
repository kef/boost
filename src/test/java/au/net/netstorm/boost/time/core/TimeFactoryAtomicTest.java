package au.net.netstorm.boost.time.core;

import java.util.Date;

import junit.framework.TestCase;

// FIXME: SC511 This belongs in "edge".
// FIXME: SC502 Wire into edge tests.
public final class TimeFactoryAtomicTest extends TestCase {

    public void testCreateRangeFromMillis() {
        // FIXME: SC777 Duplication.
        assertEquals(DATE_RANGE_050__100, TIME_FACTORY.createRange(DATE_050.getTime(), DATE_100.getTime()));
        assertEquals(DATE_RANGE_100__200, TIME_FACTORY.createRange(DATE_100.getTime(), DATE_200.getTime()));
        assertEquals(DATE_RANGE_100__400, TIME_FACTORY.createRange(DATE_100.getTime(), DATE_400.getTime()));
    }

    public void testCreateRangeFromDates() {
        // FIXME: SC777 Looks a lot like the last method...
        // FIXME: SC777 ? Use FIX instead of FIXME:
        assertEquals(DATE_RANGE_050__100, TIME_FACTORY.createRange(DATE_050, DATE_100));
        assertEquals(DATE_RANGE_100__200, TIME_FACTORY.createRange(DATE_100, DATE_200));
        assertEquals(DATE_RANGE_100__400, TIME_FACTORY.createRange(DATE_100, DATE_400));
    }

    public void testCreateTimePoint() {
        assertEquals(TIME_050, TIME_FACTORY.createTime(DATE_050));
        assertEquals(TIME_100, TIME_FACTORY.createTime(DATE_100));
        assertEquals(TIME_400, TIME_FACTORY.createTime(DATE_400));
    }

    public void testNullArgumentsIllegal() {
        assertNullArgumentsInvalid(null);
        assertNullArgumentsInvalid(null, DATE_400);
        assertNullArgumentsInvalid(DATE_200, null);
    }

    private void assertNullArgumentsInvalid(Date date) {
        try {
            TIME_FACTORY.createTime(date);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    private void assertNullArgumentsInvalid(Date start, Date end) {
        try {
            TIME_FACTORY.createRange(start, end);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    private static final TimeFactory TIME_FACTORY = new DefaultTimeFactory();

    private static final Date DATE_050 = new Date(50);
    private static final Date DATE_100 = new Date(100);
    private static final Date DATE_200 = new Date(200);
    private static final Date DATE_400 = new Date(400);

    private static final TimePoint TIME_050 = TIME_FACTORY.createTime(DATE_050);
    private static final TimePoint TIME_100 = TIME_FACTORY.createTime(DATE_100);
    private static final TimePoint TIME_400 = TIME_FACTORY.createTime(DATE_400);

    private static final StartTime START_TIME_050 = new StartTime(TIME_050);
    private static final StartTime START_TIME_100 = new StartTime(TIME_100);

    private static final Duration DURATION_050 = new Duration(50);
    private static final Duration DURATION_100 = new Duration(100);
    private static final Duration DURATION_300 = new Duration(300);

    private static final TimeRange DATE_RANGE_050__100 = new DefaultTimeRange(START_TIME_050, DURATION_050);
    private static final TimeRange DATE_RANGE_100__200 = new DefaultTimeRange(START_TIME_100, DURATION_100);
    private static final TimeRange DATE_RANGE_100__400 = new DefaultTimeRange(START_TIME_100, DURATION_300);
}


