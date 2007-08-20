package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.time.core.DefaultTimePoint;
import au.net.netstorm.boost.time.core.TimePoint;

public final class DefaultTimeHelper implements TimeHelper {
    public TimePoint beyond(TimePoint time, long amount) {
        long millis = time.getMillis();
        long nu = millis + amount;
        if (nu < millis) throw new IllegalStateException("Cannot offset " + time + " by offset.  Wrap occurs");
        return new DefaultTimePoint(nu);
    }

    // FIX BREADCRUMB 1914 Implement this and use in DefaultTimeRange, DefaultTimeRangeMaster (?).
    public TimePoint diff(TimePoint time1, TimePoint time2) {
        throw new UnsupportedOperationException();
    }
}
