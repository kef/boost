package au.net.netstorm.boost.time.core;

public final class DefaultTimeRangeMaster implements TimeRangeMaster {
    public TimeRange shorten(TimeRange range, Duration amount) {
        return bump(range, - amount.millis);
    }

    public TimeRange lengthen(TimeRange range, Duration amount) {
        return bump(range, + amount.millis);
    }

    public Duration duration(StartTime start, EndTime end) {
        return new Duration(end.point.millis - start.point.millis);
    }

    public EndTime end(TimeRange range) {
        StartTime start = range.start();
        Duration duration = range.duration();
        TimePoint time = new TimePoint(start.point.millis + duration.millis);
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
