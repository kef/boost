package au.net.netstorm.boost.bullet.time.core;

import java.util.Date;

public interface TimeFactory {
    TimePoint createTime(Date date);

    TimePoint createTime(long millis);

    TimeRange createRange(Date startDate, Date endDate);

    TimeRange createRange(long startMillis, long endMillis);

    TimeRange createRange(TimePoint start, TimePoint end);
}
