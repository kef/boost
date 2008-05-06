package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.bullet.time.core.TimePoint;

public interface TimeSpecConstructor {
    TimeSpec nu(TimePoint absolute);

    TimeSpec nu(Relative relative);

    TimeSpec nu();
}
