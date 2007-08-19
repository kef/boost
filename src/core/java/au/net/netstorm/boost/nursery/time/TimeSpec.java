package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.time.core.Duration;
import au.net.netstorm.boost.time.core.TimePoint;
import au.net.netstorm.boost.util.type.Immutable;

public interface TimeSpec extends Immutable {
    TimePoint getAbsolute();

    Duration getRelative();

    TimeType getType();
}
