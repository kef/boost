package au.net.netstorm.boost.time.type;

import au.net.netstorm.boost.primordial.Primordial;

public final class DayInMonth extends Primordial {

    public static final DayInMonth FIRST_DAY_OF_YEAR = new DayInMonth(0, MonthOfYear.JANUARY);
    public final int day;

    public DayInMonth(int day, MonthOfYear month) {
        this.day = day;
        this.month = month;
        validate();
    }
    public final MonthOfYear month;

    private void validate() {
        if (month == null) throw new IllegalArgumentException("Month cannot be null.");
        if (day < 0 || day >= month.maxDays) throw new IllegalArgumentException("Day (day="+day+") must be in the range [0;"+(month.maxDays-1)+"]");
    }
}
