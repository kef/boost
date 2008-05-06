package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.bullet.time.core.TimePoint;

public interface TimeHelper {
    TimePoint beyond(TimePoint time, long amount);

    TimePoint back(TimePoint time, long amount);

    TimePoint diff(TimePoint time1, TimePoint time2);
}
