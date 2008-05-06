package au.net.netstorm.boost.bullet.time.core;

import au.net.netstorm.boost.nursery.time.core.DefaultTimeRange;

import java.util.Date;

public final class DefaultTimeFactory implements TimeFactory {
    private final TimeRangeMaster master = new DefaultTimeRangeMaster();

    public TimePoint createTime(Date date) {
        if (date == null) throw new IllegalArgumentException("Cannot create a time from a NULL date.");
        long millis = date.getTime();
        return createTime(millis);
    }

    public TimePoint createTime(long millis) {
        return new DefaultTimePoint(millis);
    }

    public TimeRange createRange(Date startDate, Date endDate) {
        TimePoint start = createTime(startDate);
        TimePoint end = createTime(endDate);
        return createRange(start, end);
    }

    public TimeRange createRange(long startMillis, long endMillis) {
        TimePoint start = new DefaultTimePoint(startMillis);
        TimePoint end = new DefaultTimePoint(endMillis);
        return createRange(start, end);
    }

    public TimeRange createRange(TimePoint start, TimePoint end) {
        StartTime startTime = new StartTime(start);
        EndTime endTime = new EndTime(end);
        Duration duration = master.duration(startTime, endTime);
        return new DefaultTimeRange(startTime, duration);
    }
}
