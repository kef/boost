package au.net.netstorm.boost.bullet.time.core;

public interface TimeRangeMaster {
    TimeRange shorten(TimeRange range, Duration amount);

    TimeRange lengthen(TimeRange range, Duration amount);

    Duration duration(StartTime start, EndTime end);

    EndTime end(TimeRange range);
}
