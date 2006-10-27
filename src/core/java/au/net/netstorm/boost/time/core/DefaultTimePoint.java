package au.net.netstorm.boost.time.core;

// FIX SC507 Introduce type stuff.
// FIX SC502 Test drive requirement for "Data".  This was placed here to get external requirement complete
// FIX SC502 whilst cruise was broken!
// FIX SC502 Should be "immutable", not "Data".
public final class DefaultTimePoint implements TimePoint {
    private static final long EPOCH_MILLIS = 0L;
    private static final long EPOCH_ARGMAGEDDON = Long.MAX_VALUE;
    public static final TimePoint EPOCH = new DefaultTimePoint(EPOCH_MILLIS);
    public static final TimePoint ARMAGGEDON = new DefaultTimePoint(EPOCH_ARGMAGEDDON);
    private final long millis;

    public DefaultTimePoint(long millis) {
        this.millis = millis;
        validate();
    }

    public String toString() {
        return "TimePoint[" + millis + "]";
    }

    public boolean equals(Object o) {
        if (! (o instanceof DefaultTimePoint)) return false;
        return equals((TimePoint) o);
    }

    public int hashCode() {
        return (int) millis;
    }

    public static TimePoint now() {
        long now = System.currentTimeMillis();
        return new DefaultTimePoint(now);
    }

    private void validate() {
        if (millis < EPOCH_MILLIS) throw new IllegalArgumentException(
                "The specified time (time=" + millis + ") cannot be less than the epoch (EPOCH=" + EPOCH + ").");
    }

    private boolean equals(TimePoint time) {
        return time.getMillis() == millis;
    }

    public long getMillis() {
        return millis;
    }
}
