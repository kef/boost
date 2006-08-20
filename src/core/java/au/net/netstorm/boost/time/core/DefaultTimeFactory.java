package au.net.netstorm.boost.time.core;

import java.util.Date;

public final class DefaultTimeFactory implements TimeFactory {
    private final TimeRangeMaster master = new DefaultTimeRangeMaster();

    public TimeRange createRange(Date startDate, Date endDate) {
        return createRange(createTime(startDate), createTime(endDate));
    }

    public TimeRange createRange(long start, long endExclusive) {
        return createRange(new TimePoint(start), new TimePoint(endExclusive));
    }

    public TimePoint createTime(Date timeDate) {
        if (timeDate == null) throw new IllegalArgumentException("Cannot create a time from a NULL date.");
        return new TimePoint(timeDate.getTime());
    }

    private TimeRange createRange(TimePoint start, TimePoint end) {
        StartTime startTime = new StartTime(start);
        EndTime endTime = new EndTime(end);
        Duration duration = master.duration(startTime, endTime);
        return new DefaultTimeRange(startTime, duration);
    }
}
