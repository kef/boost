package au.net.netstorm.boost.time.type;

import au.net.netstorm.boost.primordial.Primordial;

public final class DaySpec extends Primordial implements Comparable {
    public final MonthSpec month;
    public final int day;

    public DaySpec(MonthSpec month, int day) {
        this.month = month;
        this.day = day;
        validate();
    }

    public int compareTo(Object o) {
        if (! getClass().isAssignableFrom(o.getClass())) throw new IllegalArgumentException("Cannot perform a comparison with a " + o.getClass() + ".");
        DaySpec spec = (DaySpec) o;
        int us = compareValue(this);
        int them = compareValue(spec);
        if (us < them) return -1;
        if (us > them) return 1;
        return 0;
    }

    private void validate() {
        int totalDays = month.totalDays;
        if (day < 0 || day >= totalDays) throw new IllegalArgumentException("The day is out of range [0.." + (totalDays - 1) + "] (day=" + day + ")");
    }

    private static int compareValue(DaySpec day) {
        MonthSpec month = day.month;
        return month.year * 10000 + month.month * 100 + day.day;
    }
}

