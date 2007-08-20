package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.time.core.TimePoint;
import au.net.netstorm.boost.util.type.Data;

public interface TimePeriod extends Data {
    TimePoint getStart();

    TimePoint getEnd();
}
