package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.time.core.Duration;
import au.net.netstorm.boost.time.core.TimePoint;

public interface TimeSpec {
    TimePoint getAbsolute();

    Duration getRelative();

    TimeType getType();
}
