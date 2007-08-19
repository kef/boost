package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.time.core.TimePoint;
import au.net.netstorm.boost.util.type.Immutable;

public interface TimeSpec extends Immutable {
    TimePoint getAbsolute();

    Relative getRelative();

    TimeType getType();
}
