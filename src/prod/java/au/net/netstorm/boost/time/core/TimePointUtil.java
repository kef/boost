package au.net.netstorm.boost.time.core;

// FIXME: SC501 Make instance.
public final class TimePointUtil {

    public static final TimePoint next(TimePoint time) {
        return relative(time, +Duration.QUANTUM.millis);
    }

    public static final TimePoint previous(TimePoint time) {
        return relative(time, -Duration.QUANTUM.millis);
    }

    private static final TimePoint relative(TimePoint time, long amount) {
        return new TimePoint(time.millis + amount);
    }
}
