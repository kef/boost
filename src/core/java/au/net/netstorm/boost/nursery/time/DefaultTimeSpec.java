package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.time.core.Duration;
import au.net.netstorm.boost.time.core.TimePoint;

public final class DefaultTimeSpec implements TimeSpec {
    private static final TimeType ABSOLUTE = TimeType.ABSOLUTE;
    private static final TimeType RELATIVE = TimeType.RELATIVE;
    private final TimePoint absolute;
    private final Duration relative;
    private final TimeType type;

    public DefaultTimeSpec(TimePoint absolute, Duration relative, TimeType type) {
        this.absolute = absolute;
        this.relative = relative;
        this.type = type;
        validate();
    }

    public TimePoint getAbsolute() {
        ensure(ABSOLUTE);
        return absolute;
    }

    public Duration getRelative() {
        ensure(RELATIVE);
        return relative;
    }

    public TimeType getType() {
        return type;
    }

    private void validate() {
        if (type == null) throw new IllegalArgumentException();
        if (!ok()) explode();
    }

    private boolean ok() {
        if (type.equals(ABSOLUTE)) return relative == null;
        if (type.equals(RELATIVE)) return absolute == null;
        if (absolute != null) return false;
        return relative != null;
    }

    private void ensure(TimeType type) {
        if (!this.type.equals(type)) pop(type);
    }

    private void explode() {
        throw new IllegalStateException("Values of absolute/relative " + absolute + "/" + relative + " do not match " + type);
    }

    private void pop(TimeType type) {
        throw new IllegalStateException("Time specification is not " + type);
    }
}
