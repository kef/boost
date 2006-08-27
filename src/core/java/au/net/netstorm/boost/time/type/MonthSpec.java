package au.net.netstorm.boost.time.type;

import au.net.netstorm.boost.primordial.Primordial;

import java.util.Calendar;
import java.util.GregorianCalendar;

// FIX SC507 Now that MonthOfYear exists, introduce it here.
public final class MonthSpec extends Primordial implements Comparable {
    public final int year;
    public final int month;
    public final int totalDays;
    public final int startDay;

    public MonthSpec(int year, int month) {
        if (month < 0 || month > 11) throw new IllegalArgumentException(
                MONTH_OUT_OF_RANGE_MSG + " year=" + year + ",month=" + month);
        this.month = month;
        this.year = year;
        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        int totalDays = DAYS_IN_MONTH[month];
        if (month == Calendar.FEBRUARY && cal.isLeapYear(year)) totalDays += 1;
        this.totalDays = totalDays;
        cal.set(year, month, 1 /* First day */, 12 /* Midday ... avoid DST stuff. */, 0, 0);
        startDay = cal.get(Calendar.DAY_OF_WEEK);
    }

    public int compareTo(Object o) {
        if (!getClass().isAssignableFrom(o.getClass()))
            throw new IllegalArgumentException("We can only perform a comparison on a " + getClass().getName() + ".  " +
                    "You provided a " + o.getClass().getName() + ".");
        MonthSpec target = (MonthSpec) o;
        return compareTo(target);
    }

    private int compareTo(MonthSpec target) {
        int us = year * 12 + month;
        int them = target.year * 12 + target.month;
        if (us == them) return 0;
        if (us < them) return -1;
        return 1;
    }

    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String MONTH_OUT_OF_RANGE_MSG = "The month must be between 0 and 11.";
}
