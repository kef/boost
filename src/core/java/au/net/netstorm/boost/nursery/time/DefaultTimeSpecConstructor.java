package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.time.core.TimePoint;

public final class DefaultTimeSpecConstructor implements TimeSpecConstructor {
    private static final TimeType ABSOLUTE = TimeType.ABSOLUTE;
    private static final TimeType RELATIVE = TimeType.RELATIVE;
    private static final TimeType NONE = TimeType.NONE;

    public TimeSpec nu(TimePoint absolute) {
        return new DefaultTimeSpec(absolute, null, ABSOLUTE);
    }

    public TimeSpec nu(Relative relative) {
        return new DefaultTimeSpec(null, relative, RELATIVE);
    }

    public TimeSpec nu() {
        return new DefaultTimeSpec(null, null, NONE);
    }
}
