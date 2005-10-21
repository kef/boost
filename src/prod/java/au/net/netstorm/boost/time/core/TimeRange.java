package au.net.netstorm.boost.time.core;

public interface TimeRange {

    public StartTime start();
    public Duration duration();
    public boolean contains(TimePoint time);
    public boolean intersects(TimeRange range);
}
