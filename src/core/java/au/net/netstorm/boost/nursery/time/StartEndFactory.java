package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.time.core.TimePoint;

public interface StartEndFactory {
    StartEnd nu(TimePoint start, TimePoint end);

    StartEnd nu(TimePoint start, Relative end);

    StartEnd nu(TimePoint start);

    StartEnd nu(Relative start, TimePoint end);

    StartEnd nu(Relative start, Relative end);

    StartEnd nu(Relative start);

    StartEnd nu();
}
