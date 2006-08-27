package au.net.netstorm.boost.time.core;

import au.net.netstorm.boost.util.type.Data;

import java.io.Serializable;

// FIX SC507 Introduce type stuff.
// FIX SC502 Test drive requirement for "Data".  This was placed here to get external requirement complete
//           whilst cruise was broken!
public final class TimePoint implements Data, Serializable {
    private static final long EPOCH_MILLIS = 0L;
    private static final long EPOCH_ARGMAGEDDON = Long.MAX_VALUE;
    public static final TimePoint EPOCH = new TimePoint(EPOCH_MILLIS);
    public static final TimePoint ARMAGGEDON = new TimePoint(EPOCH_ARGMAGEDDON);
    public final long millis;

    public TimePoint(long millis) {
        this.millis = millis;
        validate();
    }

    public String toString() {
        return "TimePoint[" + millis + "]";
    }

    public boolean equals(Object o) {
        if (! (o instanceof TimePoint)) return false;
        return equals((TimePoint) o);
    }

    public int hashCode() {
        return (int) millis;
    }

    public static TimePoint now() {
        return new TimePoint(System.currentTimeMillis());
    }

    private void validate() {
        if (millis < EPOCH_MILLIS) throw new IllegalArgumentException(
                "The specified time (time=" + millis + ") cannot be less than the epoch (EPOCH=" + EPOCH + ").");
    }

    private boolean equals(TimePoint time) {
        return time.millis == millis;
    }
}
