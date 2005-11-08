package au.net.netstorm.boost.time.core;

import java.util.Date;

import junit.framework.TestCase;

public final class TimePointUtilAtomicTest extends TestCase {

    public void testNext() {
        assertEquals(TIME_100, DefaultTimePointMaster.next(TIME_099));
        assertEquals(TIME_101, DefaultTimePointMaster.next(TIME_100));
        assertEquals(TIME_200, DefaultTimePointMaster.next(TIME_199));
        assertEquals(TIME_201, DefaultTimePointMaster.next(TIME_200));
    }

    public void testPrevious() {
        assertEquals(TIME_099, DefaultTimePointMaster.previous(TIME_100));
        assertEquals(TIME_100, DefaultTimePointMaster.previous(TIME_101));
        assertEquals(TIME_199, DefaultTimePointMaster.previous(TIME_200));
        assertEquals(TIME_200, DefaultTimePointMaster.previous(TIME_201));
    }

    public void testPreviousInvalid() {
        try {
            DefaultTimePointMaster.previous(TimePoint.EPOCH);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    public void testNextInvalid() {
        try {
            DefaultTimePointMaster.next(TimePoint.ARMAGGEDON);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    private static final TimeFactory TIME_FACTORY = new DefaultTimeFactory();

    private static final TimePoint TIME_099 = TIME_FACTORY.createTime(new Date(99));
    private static final TimePoint TIME_100 = TIME_FACTORY.createTime(new Date(100));
    private static final TimePoint TIME_101 = TIME_FACTORY.createTime(new Date(101));
    private static final TimePoint TIME_199 = TIME_FACTORY.createTime(new Date(199));
    private static final TimePoint TIME_200 = TIME_FACTORY.createTime(new Date(200));
    private static final TimePoint TIME_201 = TIME_FACTORY.createTime(new Date(201));
}