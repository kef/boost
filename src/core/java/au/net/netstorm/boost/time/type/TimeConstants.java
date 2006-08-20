package au.net.netstorm.boost.time.type;

// FIX SC507 AtomicTest for this sucker.
// FIX SC507 Consider incorporating TimeUtil (this drags in all the daylight savings stuff).
public interface TimeConstants {
    public long ONE_MILLISECOND = 1;
    public long ONE_SECOND = 1000 * ONE_MILLISECOND;
    public long ONE_MINUTE = 60 * ONE_SECOND;
    public long ONE_HOUR = 60 * ONE_MINUTE;
    public long ONE_DAY = 24 * ONE_HOUR;
    public long ONE_WEEK = 7 * ONE_DAY;
    public long ONE_YEAR = 365 * ONE_DAY;
}
