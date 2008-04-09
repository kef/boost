package au.net.netstorm.boost.time.core;

import au.net.netstorm.boost.sniper.core.BoooostCase;
import static au.net.netstorm.boost.time.core.DefaultTimePoint.ARMAGEDDON;
import static au.net.netstorm.boost.time.core.DefaultTimePoint.EPOCH;

public final class DefaultTimePointComparatorAtomicTest extends BoooostCase {
    private final TimePointComparator subject = new DefaultTimePointComparator();
    private static final int X_LATER_THAN_Y = 1;
    private static final int X_EARLIER_THAN_Y = -1;
    private static final int SAME_TIME = 0;

    public void testLaterThan() {
        int actual = subject.compare(ARMAGEDDON, EPOCH);
        assertEquals(X_LATER_THAN_Y, actual);
    }

    public void testEarlierThan() {
        int actual = subject.compare(EPOCH, ARMAGEDDON);
        assertEquals(X_EARLIER_THAN_Y, actual);
    }

    public void testSameTime() {
        checkSame(EPOCH);
        checkSame(ARMAGEDDON);
    }

    private void checkSame(TimePoint time) {
        int actual = subject.compare(time, time);
        assertEquals(SAME_TIME, actual);
    }
}
