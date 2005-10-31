package au.net.netstorm.boost.time.core;

import java.io.Serializable;

public final class StartTime implements Serializable {

    public final TimePoint point;

    public StartTime(TimePoint time) {
        this.point = time;
        validate();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (! (o instanceof StartTime)) return false;
        return equals((StartTime) o);
    }

    public int hashCode() {
        return point.hashCode();
    }

    private void validate() {
        if (point == null) throw new IllegalArgumentException("Time point for start time cannot be null.");
    }

    private boolean equals(StartTime time) {
        return point.equals(time.point);
    }
}
