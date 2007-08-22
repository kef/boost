package au.net.netstorm.boost.time.core;

import java.util.Date;
import au.net.netstorm.boost.edge.java.lang.EdgeSystem;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;

public final class DefaultTimePointMasterAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    TimePointMaster subject;
    EdgeSystem systemMock;
    private static final long NOW = 1L;
    private static final long MILLIS_1 = 12L;
    private static final long MILLIS_2 = 9L;

    public void setUpFixtures() {
        subject = new DefaultTimePointMaster();
    }

    public void testNext() {
        assertEquals(TIME_100, subject.next(TIME_099));
        assertEquals(TIME_101, subject.next(TIME_100));
        assertEquals(TIME_200, subject.next(TIME_199));
        assertEquals(TIME_201, subject.next(TIME_200));
    }

    public void testPrevious() {
        assertEquals(TIME_099, subject.previous(TIME_100));
        assertEquals(TIME_100, subject.previous(TIME_101));
        assertEquals(TIME_199, subject.previous(TIME_200));
        assertEquals(TIME_200, subject.previous(TIME_201));
    }

    public void testNow() {
        expect.oneCall(systemMock, new Long(NOW), "currentTimeMillis");
        TimePoint expected = new DefaultTimePoint(NOW);
        TimePoint actual = subject.now(systemMock);
        assertEquals(expected, actual);
    }

    public void testGet() {
        checkGet(MILLIS_1);
        checkGet(MILLIS_2);
    }

    public void testPreviousInvalid() {
        try {
            subject.previous(DefaultTimePoint.EPOCH);
            fail();
        } catch (IllegalArgumentException ex) {
        }
    }

    public void testNextInvalid() {
        try {
            subject.next(DefaultTimePoint.ARMAGEDDON);
            fail();
        } catch (IllegalArgumentException ex) {
        }
    }

    private void checkGet(long millis) {
        TimePoint timePoint = subject.get(millis);
        long actual = timePoint.getMillis();
        assertEquals(millis, actual);
    }

    private static final TimeFactory TIME_FACTORY = new DefaultTimeFactory();
    private static final TimePoint TIME_099 = TIME_FACTORY.createTime(new Date(99));
    private static final TimePoint TIME_100 = TIME_FACTORY.createTime(new Date(100));
    private static final TimePoint TIME_101 = TIME_FACTORY.createTime(new Date(101));
    private static final TimePoint TIME_199 = TIME_FACTORY.createTime(new Date(199));
    private static final TimePoint TIME_200 = TIME_FACTORY.createTime(new Date(200));
    private static final TimePoint TIME_201 = TIME_FACTORY.createTime(new Date(201));
}