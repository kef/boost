package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.gunge.type.Immutable;

public interface TimeSpec extends Immutable {
    TimePoint getAbsolute();

    Relative getRelative();

    TimeType getType();
}
