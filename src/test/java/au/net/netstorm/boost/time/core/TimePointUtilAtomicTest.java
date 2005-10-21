package au.net.netstorm.boost.time.core;

import java.util.Date;

import junit.framework.TestCase;

public final class TimePointUtilAtomicTest extends TestCase {

    public void testNext() {
        assertEquals(TIME_100, TimePointUtil.next(TIME_099));
        assertEquals(TIME_101, TimePointUtil.next(TIME_100));
        assertEquals(TIME_200, TimePointUtil.next(TIME_199));
        assertEquals(TIME_201, TimePointUtil.next(TIME_200));
    }

    public void testPrevious() {
        assertEquals(TIME_099, TimePointUtil.previous(TIME_100));
        assertEquals(TIME_100, TimePointUtil.previous(TIME_101));
        assertEquals(TIME_199, TimePointUtil.previous(TIME_200));
        assertEquals(TIME_200, TimePointUtil.previous(TIME_201));
    }

    public void testPreviousInvalid() {
        try {
            TimePointUtil.previous(TimePoint.EPOCH);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    public void testNextInvalid() {
        try {
            TimePointUtil.next(TimePoint.ARMAGGEDON);
            fail();
        } catch (IllegalArgumentException ex) { }
    }


    private static final TimePoint TIME_099 = LegacyDateFactory.createTime(new Date(99));
    private static final TimePoint TIME_100 = LegacyDateFactory.createTime(new Date(100));
    private static final TimePoint TIME_101 = LegacyDateFactory.createTime(new Date(101));
    private static final TimePoint TIME_199 = LegacyDateFactory.createTime(new Date(199));
    private static final TimePoint TIME_200 = LegacyDateFactory.createTime(new Date(200));
    private static final TimePoint TIME_201 = LegacyDateFactory.createTime(new Date(201));
}