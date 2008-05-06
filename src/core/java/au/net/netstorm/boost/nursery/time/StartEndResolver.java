package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.bullet.time.core.TimePoint;

public interface StartEndResolver {
    TimePeriod get(StartEnd times, TimePoint now);
}
