package au.net.netstorm.boost.time.core;

// FIXME: SC501 Make instance.
public final class TimeRangeUtil {

    public static final TimeRange shorten(TimeRange range, Duration amount) {
        return bump(range, - amount.millis);
    }

    public static final TimeRange lengthen(TimeRange range, Duration amount) {
        return bump(range, + amount.millis);
    }

    public static final Duration duration(StartTime start, EndTime end) {
        return new Duration(end.point.millis - start.point.millis);
    }

    public static final EndTime end(TimeRange range) {
        return new EndTime(new TimePoint(range.start().point.millis + range.duration().millis));
    }

    private static final TimeRange bump(TimeRange range, long amount) {
        return new DefaultTimeRange(range.start(), new Duration(range.duration().millis + amount));
    }
}
