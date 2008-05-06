package au.net.netstorm.boost.bullet.time.core;

public interface TimeRange {
    StartTime start();

    Duration duration();

    boolean contains(TimePoint time);

    boolean intersects(TimeRange range);
}
