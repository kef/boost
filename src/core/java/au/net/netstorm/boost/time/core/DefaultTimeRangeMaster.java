package au.net.netstorm.boost.time.core;

import au.net.netstorm.boost.nursery.time.core.DefaultTimeRange;

public final class DefaultTimeRangeMaster implements TimeRangeMaster {
    public TimeRange shorten(TimeRange range, Duration amount) {
        return bump(range, -amount.millis);
    }

    public TimeRange lengthen(TimeRange range, Duration amount) {
        return bump(range, +amount.millis);
    }

    public Duration duration(StartTime start, EndTime end) {
        return new Duration(end.point.getMillis() - start.point.getMillis());
    }

    public EndTime end(TimeRange range) {
        StartTime start = range.start();
        Duration duration = range.duration();
        TimePoint time = new DefaultTimePoint(start.point.getMillis() + duration.millis);
        return new EndTime(time);
    }

    private TimeRange bump(TimeRange range, long amount) {
        StartTime start = range.start();
        Duration duration = range.duration();
        long newLength = duration.millis + amount;
        Duration newDuration = new Duration(newLength);
        return new DefaultTimeRange(start, newDuration);
    }
}
