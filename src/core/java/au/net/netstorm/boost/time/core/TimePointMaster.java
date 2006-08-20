package au.net.netstorm.boost.time.core;

public interface TimePointMaster {
    TimePoint next(TimePoint time);

    TimePoint previous(TimePoint time);
}
