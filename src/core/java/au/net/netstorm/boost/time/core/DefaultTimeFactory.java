package au.net.netstorm.boost.time.core;

import java.util.Date;

// FIXME: SC502 Instancise.
public final class DefaultTimeFactory implements TimeFactory {

    public final TimeRange createRange(Date startDate, Date endDate) {
        return createRange(createTime(startDate), createTime(endDate));
    }

    public final TimeRange createRange(long start, long endExclusive) {
        return createRange(new TimePoint(start), new TimePoint(endExclusive));
    }

    public final TimePoint createTime(Date timeDate) {
        if (timeDate == null) throw new IllegalArgumentException("Cannot create a time from a NULL date.");
        return new TimePoint(timeDate.getTime());
    }

    private final TimeRange createRange(TimePoint start, TimePoint end) {
        StartTime startTime = new StartTime(start);
        EndTime endTime = new EndTime(end);
        Duration duration = TimeRangeUtil.duration(startTime, endTime);
        return new DefaultTimeRange(startTime, duration);
    }
}
