package au.net.netstorm.boost.bullet.time.core;

import au.net.netstorm.boost.edge.java.lang.EdgeSystem;

// FIX SC507 Make instance.
public final class DefaultTimePointMaster implements TimePointMaster {
    public TimePoint next(TimePoint time) {
        return relative(time, +Duration.QUANTUM.millis);
    }

    public TimePoint previous(TimePoint time) {
        return relative(time, -Duration.QUANTUM.millis);
    }

    public TimePoint now(EdgeSystem system) {
        long current = system.currentTimeMillis();
        return new DefaultTimePoint(current);
    }

    public TimePoint get(long millis) {
        return new DefaultTimePoint(millis);
    }

    private TimePoint relative(TimePoint time, long amount) {
        return new DefaultTimePoint(time.getMillis() + amount);
    }
}
