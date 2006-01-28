package au.net.netstorm.boost.time.core;

import java.io.Serializable;

// FIXME: SC507 Introduce type stuff.
public final class TimePoint implements Serializable {

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
        return "TimePoint["+millis+"]";
    }

    public boolean equals(Object o) {
//        if (o == null) return false;
        if (! (o instanceof TimePoint)) return false;
        return equals((TimePoint) o);
    }

    public int hashCode() {
        return (int) millis;
    }

    public static final TimePoint now() {
        return new TimePoint(System.currentTimeMillis());
    }

    private void validate() {
        if (millis < EPOCH_MILLIS) throw new IllegalArgumentException("The specified time (time="+millis+") cannot be less than the epoch (EPOCH="+EPOCH+").");
    }

    private boolean equals(TimePoint time) {
        return time.millis == millis;
    }
}
