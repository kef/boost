package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.bullet.time.core.DefaultTimePoint;
import au.net.netstorm.boost.bullet.time.core.TimePoint;

public final class DefaultTimeHelper implements TimeHelper {
    public TimePoint beyond(TimePoint time, long amount) {
        return jump(time, amount, false);
    }

    public TimePoint back(TimePoint time, long amount) {
        return jump(time, amount, true);
    }

    // FIX BREADCRUMB 1914 Implement this and use in DefaultTimeRange, DefaultTimeRangeMaster (?).
    public TimePoint diff(TimePoint time1, TimePoint time2) {
        throw new UnsupportedOperationException();
    }

    private TimePoint jump(TimePoint time, long amount, boolean backwards) {
        long millis = time.getMillis();
        long relative = (backwards ? -1 * amount : amount);
        long nu = millis + relative;
        checkWrap(nu, millis, backwards);
        return new DefaultTimePoint(nu);
    }

    private void checkWrap(long nu, long millis, boolean backwards) {
        boolean wrapped = backwards ? nu > millis : nu < millis;
        if (wrapped) throw new IllegalStateException("Cannot offset " + millis + " by offset.  Wrap occurs");
    }
}
