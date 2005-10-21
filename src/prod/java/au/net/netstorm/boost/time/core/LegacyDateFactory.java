package au.net.netstorm.boost.time.core;

import java.util.Date;

public final class LegacyDateFactory {

    public static final TimeRange createRange(Date startDate, Date endDate) {
        return createRange(createTime(startDate), createTime(endDate));
    }

    public static final TimeRange createRange(long start, long endExclusive) {
        return createRange(new TimePoint(start), new TimePoint(endExclusive));
    }

    public static final TimePoint createTime(Date timeDate) {
        if (timeDate == null) throw new IllegalArgumentException("Cannot create a time from a NULL date.");
        return new TimePoint(timeDate.getTime());
    }

    private static final TimeRange createRange(TimePoint start, TimePoint end) {
        StartTime startTime = new StartTime(start);
        EndTime endTime = new EndTime(end);
        Duration duration = TimeRangeUtil.duration(startTime, endTime);
        return new DefaultTimeRange(startTime, duration);
    }
}
