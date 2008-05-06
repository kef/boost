package au.net.netstorm.boost.bullet.time.core;

import java.io.Serializable;

// FIX SC507 They will be serializable once they become immutable.

// FIX SC507 Make these guys immutable.
public final class EndTime implements Serializable {
    public final TimePoint point;

    public EndTime(TimePoint time) {
        this.point = time;
        validate();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof EndTime)) return false;
        return equals((EndTime) o);
    }

    public int hashCode() {
        return point.hashCode();
    }

    private void validate() {
        if (point == null) throw new IllegalArgumentException("Time point for end time cannot be null.");
    }

    private boolean equals(EndTime time) {
        return point.equals(time.point);
    }
}
