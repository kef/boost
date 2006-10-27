package au.net.netstorm.boost.time.core;

// FIX SC507 Make instance.
public final class DefaultTimePointMaster implements TimePointMaster {
    public TimePoint next(TimePoint time) {
        return relative(time, +Duration.QUANTUM.millis);
    }

    public TimePoint previous(TimePoint time) {
        return relative(time, -Duration.QUANTUM.millis);
    }

    private TimePoint relative(TimePoint time, long amount) {
        return new DefaultTimePoint(time.getMillis() + amount);
    }
}
