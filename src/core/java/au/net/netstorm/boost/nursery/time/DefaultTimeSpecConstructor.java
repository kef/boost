package au.net.netstorm.boost.nursery.time;

import static au.net.netstorm.boost.nursery.time.TimeType.ABSOLUTE;
import static au.net.netstorm.boost.nursery.time.TimeType.NONE;
import static au.net.netstorm.boost.nursery.time.TimeType.RELATIVE;
import au.net.netstorm.boost.time.core.TimePoint;

public final class DefaultTimeSpecConstructor implements TimeSpecConstructor {
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
