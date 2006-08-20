package au.net.netstorm.boost.time.core;

import junit.framework.TestCase;

import java.util.Date;

public final class DefaultTimeRangeAtomicTest extends TestCase {
    public void testNullsInvalidInDualConstructor() {
        assertNullsInvalidInDualConstructor(null, Duration.QUANTUM);
        assertNullsInvalidInDualConstructor(new StartTime(TimePoint.EPOCH), null);
    }

    public void testContains() {
        assertFalse(range.contains(TIME_099));
        assertTrue(range.contains(TIME_100));
        assertTrue(range.contains(TIME_200));
        assertFalse(range.contains(TIME_300));
        assertFalse(range.contains(TIME_301));
    }

    public void testGetters() {
        assertGetters(START_TIME_050, DURATION_001);
        assertGetters(START_TIME_100, DURATION_999);
    }

    private void assertGetters(StartTime start, Duration duration) {
        TimeRange range = new DefaultTimeRange(start, duration);
        assertEquals(start, range.start());
        assertEquals(duration, range.duration());
    }

    public void testIntersects() {
        assertIntersects(false, START_TIME_050, END_TIME_100);
        assertIntersects(false, START_TIME_050, END_TIME_100);
        assertIntersects(false, START_TIME_099, END_TIME_100);
        assertIntersects(true, START_TIME_100, END_TIME_101);
        assertIntersects(true, START_TIME_101, END_TIME_102);
        assertIntersects(true, START_TIME_050, END_TIME_101);
        assertIntersects(true, START_TIME_050, END_TIME_202);
        assertIntersects(true, START_TIME_200, END_TIME_202);
        assertIntersects(true, START_TIME_100, END_TIME_300);
        assertIntersects(true, START_TIME_200, END_TIME_201);
        assertIntersects(true, START_TIME_050, END_TIME_400);
        assertIntersects(true, START_TIME_202, END_TIME_400);
        assertIntersects(true, START_TIME_299, END_TIME_300);
        assertIntersects(false, START_TIME_300, END_TIME_301);
        assertIntersects(false, START_TIME_300, END_TIME_400);
    }

    public void testEquality() {
        assertFalse(range.equals(NULL));
        assertFalse(range.equals(void.class));
        assertNotEquals(range, new DefaultTimeRange(START_TIME_100, DURATION_201));
        assertNotEquals(range, new DefaultTimeRange(START_TIME_100, DURATION_199));
        assertNotEquals(range, new DefaultTimeRange(START_TIME_099, DURATION_201));
        assertNotEquals(range, new DefaultTimeRange(START_TIME_101, DURATION_199));
        assertEquals(range, new DefaultTimeRange(new StartTime(new TimePoint(100)), new Duration(200)));
    }

    public void testHashCode() {
        assertHashCode(500, new DefaultTimeRange(START_TIME_500, DURATION_001));
        assertHashCode(500, new DefaultTimeRange(START_TIME_500, DURATION_200));
        assertHashCode(499, new DefaultTimeRange(START_TIME_499, DURATION_001));
        assertHashCode(499, new DefaultTimeRange(START_TIME_499, DURATION_200));
        assertHashCode(1, new DefaultTimeRange(START_TIME_0x7FFFFFFF00000001, DURATION_001));
        assertHashCode(1, new DefaultTimeRange(START_TIME_0x7FFFFFFF00000001, DURATION_200));
    }

    public void testToString() {
        checkToString("DefaultTimeRange[start=100,duration=1]", START_TIME_100, DURATION_001);
        checkToString("DefaultTimeRange[start=99,duration=199]", START_TIME_099, DURATION_199);
    }

    private void checkToString(String expected, StartTime start, Duration duration) {
        assertEquals(expected, new DefaultTimeRange(start, duration).toString());
    }

    private void assertNullsInvalidInDualConstructor(StartTime start, Duration duration) {
        try {
            new DefaultTimeRange(start, duration);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    private void assertIntersects(boolean expected, StartTime start, EndTime end) {
        Duration duration = TIME_RANGE_MASTER.duration(start, end);
        TimeRange testRange = new DefaultTimeRange(start, duration);
        assertEquals(expected, range.intersects(testRange));
    }

    private void assertNotEquals(TimeRange r1, TimeRange r2) {
        assertFalse(r1.equals(r2));
        assertFalse(r2.equals(r1));
    }

    private void assertHashCode(int hash, TimeRange range) {
        assertEquals(hash, range.hashCode());
    }

    private TimeRange range = new DefaultTimeRange(START_TIME_100, DURATION_200);
    private static final TimeFactory TIME_FACTORY = new DefaultTimeFactory();
    private static final TimeRangeMaster TIME_RANGE_MASTER = new DefaultTimeRangeMaster();
    private static final TimePoint TIME_050 = TIME_FACTORY.createTime(new Date(50));
    private static final TimePoint TIME_099 = TIME_FACTORY.createTime(new Date(99));
    private static final TimePoint TIME_100 = TIME_FACTORY.createTime(new Date(100));
    private static final TimePoint TIME_101 = TIME_FACTORY.createTime(new Date(101));
    private static final TimePoint TIME_102 = TIME_FACTORY.createTime(new Date(102));
    private static final TimePoint TIME_200 = TIME_FACTORY.createTime(new Date(200));
    private static final TimePoint TIME_201 = TIME_FACTORY.createTime(new Date(201));
    private static final TimePoint TIME_202 = TIME_FACTORY.createTime(new Date(202));
    private static final TimePoint TIME_299 = TIME_FACTORY.createTime(new Date(299));
    private static final TimePoint TIME_300 = TIME_FACTORY.createTime(new Date(300));
    private static final TimePoint TIME_301 = TIME_FACTORY.createTime(new Date(301));
    private static final TimePoint TIME_400 = TIME_FACTORY.createTime(new Date(400));
    private static final TimePoint TIME_500 = new TimePoint(500);
    private static final TimePoint TIME_499 = new TimePoint(499);
    private static final TimePoint TIME_0x7FFFFFFF00000001 = new TimePoint(0x7FFFFFFF00000001L);
    private static final StartTime START_TIME_050 = new StartTime(TIME_050);
    private static final StartTime START_TIME_099 = new StartTime(TIME_099);
    private static final StartTime START_TIME_100 = new StartTime(TIME_100);
    private static final StartTime START_TIME_101 = new StartTime(TIME_101);
    private static final StartTime START_TIME_200 = new StartTime(TIME_200);
    private static final StartTime START_TIME_202 = new StartTime(TIME_202);
    private static final StartTime START_TIME_299 = new StartTime(TIME_299);
    private static final StartTime START_TIME_300 = new StartTime(TIME_300);
    private static final StartTime START_TIME_500 = new StartTime(TIME_500);
    private static final StartTime START_TIME_499 = new StartTime(TIME_499);
    private static final StartTime START_TIME_0x7FFFFFFF00000001 = new StartTime(TIME_0x7FFFFFFF00000001);
    private static final EndTime END_TIME_100 = new EndTime(TIME_100);
    private static final EndTime END_TIME_101 = new EndTime(TIME_101);
    private static final EndTime END_TIME_102 = new EndTime(TIME_102);
    private static final EndTime END_TIME_201 = new EndTime(TIME_201);
    private static final EndTime END_TIME_202 = new EndTime(TIME_202);
    private static final EndTime END_TIME_300 = new EndTime(TIME_300);
    private static final EndTime END_TIME_301 = new EndTime(TIME_301);
    private static final EndTime END_TIME_400 = new EndTime(TIME_400);
    private static final Duration DURATION_001 = new Duration(1);
    private static final Duration DURATION_200 = new Duration(200);
    private static final Duration DURATION_201 = new Duration(201);
    private static final Duration DURATION_199 = new Duration(199);
    private static final Duration DURATION_999 = new Duration(999);
    private static final Object NULL = null;
}

