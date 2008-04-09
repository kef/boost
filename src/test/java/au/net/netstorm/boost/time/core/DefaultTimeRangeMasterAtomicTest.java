package au.net.netstorm.boost.time.core;

import java.util.Date;
import au.net.netstorm.boost.nursery.time.core.DefaultTimeRange;
import au.net.netstorm.boost.sniper.core.BoooostCase;

// DEBT ClassDataAbstractionCoupling {
public final class DefaultTimeRangeMasterAtomicTest extends BoooostCase {
    public void testDuration() {
        assertEquals(DURATION_200, master.duration(START_TIME_200, END_TIME_400));
        assertEquals(DURATION_001, master.duration(START_TIME_099, END_TIME_100));
    }

    public void testInvalidDuration() {
        assertInvalidDuration(START_TIME_100, END_TIME_100);
        assertInvalidDuration(START_TIME_400, END_TIME_050);
    }

    public void testShorten() {
        assertEquals(DATE_RANGE_050_099, master.shorten(DATE_RANGE_050_100, DURATION_001));
        assertEquals(DATE_RANGE_100_101, master.shorten(DATE_RANGE_100_200, DURATION_099));
    }

    public void testInvalidShorten() {
        assertInvalidShorten(DATE_RANGE_099_100, DURATION_001);
        assertInvalidShorten(DATE_RANGE_050_100, DURATION_050);
        assertInvalidShorten(DATE_RANGE_100_200, DURATION_100);
        assertInvalidShorten(DATE_RANGE_100_200, DURATION_200);
    }

    public void testLengthen() {
        assertEquals(DATE_RANGE_050_100, master.lengthen(DATE_RANGE_050_099, DURATION_001));
        assertEquals(DATE_RANGE_100_200, master.lengthen(DATE_RANGE_100_101, DURATION_099));
    }

    public void testEnd() {
        assertEquals(END_TIME_100, master.end(DATE_RANGE_050_100));
        assertEquals(END_TIME_100, master.end(DATE_RANGE_099_100));
        assertEquals(END_TIME_400, master.end(DATE_RANGE_100_400));
    }

    private void assertInvalidDuration(StartTime start, EndTime end) {
        try {
            master.duration(start, end);
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

    private void assertInvalidShorten(TimeRange range, Duration duration) {
        try {
            master.shorten(range, duration);
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

    private static final TimeFactory TIME_FACTORY = new DefaultTimeFactory();
    // FIX SC502 Make sure this is an interface reference.
    private static TimeRangeMaster master = new DefaultTimeRangeMaster();
    private static final TimePoint TIME_050 = TIME_FACTORY.createTime(new Date(50));
    private static final TimePoint TIME_099 = TIME_FACTORY.createTime(new Date(99));
    private static final TimePoint TIME_100 = TIME_FACTORY.createTime(new Date(100));
    private static final TimePoint TIME_200 = TIME_FACTORY.createTime(new Date(200));
    private static final TimePoint TIME_400 = TIME_FACTORY.createTime(new Date(400));
    private static final StartTime START_TIME_050 = new StartTime(TIME_050);
    private static final StartTime START_TIME_099 = new StartTime(TIME_099);
    private static final StartTime START_TIME_100 = new StartTime(TIME_100);
    private static final StartTime START_TIME_200 = new StartTime(TIME_200);
    private static final StartTime START_TIME_400 = new StartTime(TIME_400);
    private static final EndTime END_TIME_050 = new EndTime(TIME_050);
    private static final EndTime END_TIME_100 = new EndTime(TIME_100);
    private static final EndTime END_TIME_400 = new EndTime(TIME_400);
    private static final Duration DURATION_001 = new Duration(1);
    private static final Duration DURATION_049 = new Duration(49);
    private static final Duration DURATION_050 = new Duration(50);
    private static final Duration DURATION_099 = new Duration(99);
    private static final Duration DURATION_100 = new Duration(100);
    private static final Duration DURATION_200 = new Duration(200);
    private static final Duration DURATION_300 = new Duration(300);
    private static final TimeRange DATE_RANGE_050_099 = new DefaultTimeRange(START_TIME_050, DURATION_049);
    private static final TimeRange DATE_RANGE_050_100 = new DefaultTimeRange(START_TIME_050, DURATION_050);
    private static final TimeRange DATE_RANGE_099_100 = new DefaultTimeRange(START_TIME_099, DURATION_001);
    private static final TimeRange DATE_RANGE_100_101 = new DefaultTimeRange(START_TIME_100, DURATION_001);
    private static final TimeRange DATE_RANGE_100_200 = new DefaultTimeRange(START_TIME_100, DURATION_100);
    private static final TimeRange DATE_RANGE_100_400 = new DefaultTimeRange(START_TIME_100, DURATION_300);
}
// } DEBT ClassDataAbstractionCoupling
