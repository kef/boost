package au.net.netstorm.boost.bullet.time.type;

// FIX SC507 Consider incorporating TimeUtil (this drags in all the daylight savings stuff).
public class TimeConstants {
    public static final long ONE_MILLISECOND = 1;
    public static final long ONE_SECOND = 1000 * ONE_MILLISECOND;
    public static final long ONE_MINUTE = 60 * ONE_SECOND;
    public static final long ONE_HOUR = 60 * ONE_MINUTE;
    public static final long ONE_DAY = 24 * ONE_HOUR;
    public static final long ONE_WEEK = 7 * ONE_DAY;
    public static final long ONE_YEAR = 365 * ONE_DAY;
}
