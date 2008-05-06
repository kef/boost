package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.bullet.time.core.TimePoint;

public final class DefaultStartEndFactory implements StartEndFactory {
    private final TimeSpecConstructor times = new DefaultTimeSpecConstructor();

    public StartEnd nu(TimePoint start, TimePoint end) {
        TimeSpec s = times.nu(start);
        TimeSpec e = times.nu(end);
        return nu(s, e);
    }

    public StartEnd nu(TimePoint start, Relative end) {
        TimeSpec s = times.nu(start);
        TimeSpec e = times.nu(end);
        return nu(s, e);
    }

    public StartEnd nu(TimePoint start) {
        TimeSpec s = times.nu(start);
        TimeSpec e = times.nu();
        return nu(s, e);
    }

    public StartEnd nu(Relative start, TimePoint end) {
        TimeSpec s = times.nu(start);
        TimeSpec e = times.nu(end);
        return nu(s, e);
    }

    public StartEnd nu(Relative start, Relative end) {
        TimeSpec s = times.nu(start);
        TimeSpec e = times.nu(end);
        return nu(s, e);
    }

    public StartEnd nu(Relative start) {
        TimeSpec s = times.nu(start);
        TimeSpec e = times.nu();
        return nu(s, e);
    }

    public StartEnd nu() {
        TimeSpec s = times.nu();
        TimeSpec e = times.nu();
        return nu(s, e);
    }

    private StartEnd nu(TimeSpec s, TimeSpec e) {
        return new DefaultStartEnd(s, e);
    }
}
