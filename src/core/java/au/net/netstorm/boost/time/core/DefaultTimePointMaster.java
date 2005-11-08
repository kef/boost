package au.net.netstorm.boost.time.core;

// FIXME: SC507 Make instance.
public final class DefaultTimePointMaster implements TimePointMaster {

    public final TimePoint next(TimePoint time) {
        return relative(time, +Duration.QUANTUM.millis);
    }

    public final TimePoint previous(TimePoint time) {
        return relative(time, -Duration.QUANTUM.millis);
    }

    private final TimePoint relative(TimePoint time, long amount) {
        return new TimePoint(time.millis + amount);
    }
}
