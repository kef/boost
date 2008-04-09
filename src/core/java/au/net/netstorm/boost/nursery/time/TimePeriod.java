package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.time.core.TimePoint;

public interface TimePeriod extends Data {
    TimePoint getStart();

    TimePoint getEnd();
}
