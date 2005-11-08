package au.net.netstorm.boost.time.core;

import java.io.Serializable;

public final class DefaultTimeRange implements TimeRange, Serializable {
    public StartTime start() {
        return start;
    }

    public Duration duration() {
        return duration;
    }

    public boolean contains(TimePoint time) {
        long diff = time.millis - start.point.millis;
        return diff < duration.millis && diff >= 0;
    }

    public boolean intersects(TimeRange range) {
        return range.contains(start().point) || range.contains(DefaultTimePointMaster.previous(TimeRangeUtil.end(this).point)) || this.contains(range.start().point) || this.contains(DefaultTimePointMaster.previous(TimeRangeUtil.end(range).point));
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (! (o instanceof TimeRange)) return false;
        return equals((TimeRange) o);
    }

    public int hashCode() {
        return start.hashCode();
    }

    public String toString() {
        return "DefaultTimeRange[start=" + start.point.millis + ",duration=" + duration.millis + "]";
    }

    public DefaultTimeRange(StartTime start, Duration duration) {
        this.start = start;
        this.duration = duration;
        validate();
    }

    private void validate() {
        if (start == null) throw new IllegalArgumentException("Start time cannot be null.");
        if (duration == null) throw new IllegalArgumentException("Duration cannot be null.");
    }

    private boolean equals(TimeRange range) {
        if (! range.start().equals(start)) return false;
        return range.duration().equals(duration);
    }

    private final StartTime start;
    private final Duration duration;
}
