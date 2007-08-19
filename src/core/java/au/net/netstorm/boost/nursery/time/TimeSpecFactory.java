package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.time.core.TimePoint;

public interface TimeSpecFactory {
    TimeSpec nu(TimePoint absolute);

    TimeSpec nu(Relative relative);

    TimeSpec nu();
}
