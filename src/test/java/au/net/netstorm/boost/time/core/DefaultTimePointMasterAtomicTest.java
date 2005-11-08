package au.net.netstorm.boost.time.core;

import java.util.Date;

import junit.framework.TestCase;

public final class DefaultTimePointMasterAtomicTest extends TestCase {

    public void testNext() {
        assertEquals(TIME_100, master.next(TIME_099));
        assertEquals(TIME_101, master.next(TIME_100));
        assertEquals(TIME_200, master.next(TIME_199));
        assertEquals(TIME_201, master.next(TIME_200));
    }

    public void testPrevious() {
        assertEquals(TIME_099, master.previous(TIME_100));
        assertEquals(TIME_100, master.previous(TIME_101));
        assertEquals(TIME_199, master.previous(TIME_200));
        assertEquals(TIME_200, master.previous(TIME_201));
    }

    public void testPreviousInvalid() {
        try {
            master.previous(TimePoint.EPOCH);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    public void testNextInvalid() {
        try {
            master.next(TimePoint.ARMAGGEDON);
            fail();
        } catch (IllegalArgumentException ex) { }
    }

    private final TimePointMaster master = new DefaultTimePointMaster();
    private static final TimeFactory TIME_FACTORY = new DefaultTimeFactory();
    private static final TimePoint TIME_099 = TIME_FACTORY.createTime(new Date(99));
    private static final TimePoint TIME_100 = TIME_FACTORY.createTime(new Date(100));
    private static final TimePoint TIME_101 = TIME_FACTORY.createTime(new Date(101));
    private static final TimePoint TIME_199 = TIME_FACTORY.createTime(new Date(199));
    private static final TimePoint TIME_200 = TIME_FACTORY.createTime(new Date(200));
    private static final TimePoint TIME_201 = TIME_FACTORY.createTime(new Date(201));
}