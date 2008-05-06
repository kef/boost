package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.gunge.type.Data;

public interface TimePeriod extends Data {
    TimePoint getStart();

    TimePoint getEnd();
}
