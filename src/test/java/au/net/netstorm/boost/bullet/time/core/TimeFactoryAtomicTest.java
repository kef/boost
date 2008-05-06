package au.net.netstorm.boost.bullet.time.core;

import au.net.netstorm.boost.nursery.time.core.DefaultTimeRange;
import au.net.netstorm.boost.sniper.core.BoooostCase;

import java.util.Date;

// FIX SC511 This belongs in "edge".

// FIX SC502 Wire into edge tests.
public final class TimeFactoryAtomicTest extends BoooostCase {
    public void testCreateRange() {
        // FIX SC777 ? More than just triangulation values - is this an integration test.
        checkCreateRange(DATE_RANGE_050_100, DATE_050, DATE_100);
        checkCreateRange(DATE_RANGE_100_200, DATE_100, DATE_200);
        checkCreateRange(DATE_RANGE_100_400, DATE_100, DATE_400);
    }

    public void testCreateTimePoint() {
        // FIX SC600 Move this out
        // FIX SC600 Combine this with method in other class.
        assertEquals(TIME_050, TIME_FACTORY.createTime(DATE_050));
        assertEquals(TIME_100, TIME_FACTORY.createTime(DATE_100));
        assertEquals(TIME_400, TIME_FACTORY.createTime(DATE_400));
    }

    public void testNullArgumentsIllegal() {
        assertNullArgumentsInvalid(null);
        assertNullArgumentsInvalid(null, DATE_400);
        assertNullArgumentsInvalid(DATE_200, null);
    }

    private void checkCreateRange(TimeRange expectedRange, Date startDate, Date endDate) {
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        // FIX SC777 ? createRange is overloaded.  Sort this out.
        checkCreateRangeFromDates(expectedRange, startDate, endDate);
        checkCreateRangeFromMillis(expectedRange, startTime, endTime);
    }

    private void checkCreateRangeFromMillis(TimeRange expectedRange, long startTime, long endTime) {
        TimeRange actualRange = TIME_FACTORY.createRange(startTime, endTime);
        assertEquals(expectedRange, actualRange);
    }

    private void checkCreateRangeFromDates(TimeRange expectedRange, Date startDate, Date endDate) {
        TimeRange actualRange = TIME_FACTORY.createRange(startDate, endDate);
        assertEquals(expectedRange, actualRange);
    }

    private void assertNullArgumentsInvalid(Date date) {
        try {
            TIME_FACTORY.createTime(date);
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

    private void assertNullArgumentsInvalid(Date start, Date end) {
        try {
            TIME_FACTORY.createRange(start, end);
            fail();
        } catch (IllegalArgumentException expected) {
        }
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
    // FIX SC777 Use test values from DurationAtomicTest instead.
    // FIX SC777 Look for other places like this that use Durations for tests.
    private static final Duration DURATION_050 = new Duration(50);
    private static final Duration DURATION_100 = new Duration(100);
    private static final Duration DURATION_300 = new Duration(300);
    private static final TimeRange DATE_RANGE_050_100 = new DefaultTimeRange(START_TIME_050, DURATION_050);
    private static final TimeRange DATE_RANGE_100_200 = new DefaultTimeRange(START_TIME_100, DURATION_100);
    private static final TimeRange DATE_RANGE_100_400 = new DefaultTimeRange(START_TIME_100, DURATION_300);
}
