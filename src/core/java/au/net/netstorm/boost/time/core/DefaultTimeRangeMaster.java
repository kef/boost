package au.net.netstorm.boost.time.core;

// FIXME: SC507 Make instance.
public final class DefaultTimeRangeMaster implements TimeRangeMaster {

    public final TimeRange shorten(TimeRange range, Duration amount) {
        return bump(range, - amount.millis);
    }

    public final TimeRange lengthen(TimeRange range, Duration amount) {
        return bump(range, + amount.millis);
    }

    public final Duration duration(StartTime start, EndTime end) {
        return new Duration(end.point.millis - start.point.millis);
    }

    public final EndTime end(TimeRange range) {
        return new EndTime(new TimePoint(range.start().point.millis + range.duration().millis));
    }

    private final TimeRange bump(TimeRange range, long amount) {
        return new DefaultTimeRange(range.start(), new Duration(range.duration().millis + amount));
    }
}
