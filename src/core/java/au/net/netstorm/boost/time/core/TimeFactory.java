package au.net.netstorm.boost.time.core;

import java.util.Date;

public interface TimeFactory {
    TimeRange createRange(Date startDate, Date endDate);

    TimeRange createRange(long start, long endExclusive);

    TimePoint createTime(Date timeDate);

    TimeRange createRange(TimePoint start, TimePoint end);
}
