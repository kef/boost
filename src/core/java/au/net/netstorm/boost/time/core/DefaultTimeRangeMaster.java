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
        return new EndTime(new TimePoint(range.start().point.millis + range.duration().millis));
    }

    private TimeRange bump(TimeRange range, long amount) {
        return new DefaultTimeRange(range.start(), new Duration(range.duration().millis + amount));
    }
}
