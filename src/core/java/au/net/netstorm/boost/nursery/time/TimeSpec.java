package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.gunge.type.Immutable;
import au.net.netstorm.boost.time.core.TimePoint;

public interface TimeSpec extends Immutable {
    TimePoint getAbsolute();

    Relative getRelative();

    TimeType getType();
}
