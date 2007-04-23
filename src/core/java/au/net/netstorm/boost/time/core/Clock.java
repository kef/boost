package au.net.netstorm.boost.time.core;

public interface Clock {
    TimePoint now();

    TimePoint getTime(long millis);
}
