package au.net.netstorm.boost.time.type;

public final class DayInMonth {

    public static final DayInMonth FIRST_DAY_OF_YEAR = new DayInMonth(0, MonthOfYear.JANUARY);
    public final int day;

    public DayInMonth(int day, MonthOfYear month) {
        this.day = day;
        this.month = month;
        validate();
    }
    public final MonthOfYear month;

    public int hashCode() { return 100; }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DayInMonth)) return false;
        return equals((DayInMonth)o);
    }

    public String toString() {
        return "" + month + " " + day;
    }

    // ---- PRIVATE:

    private void validate() {
        if (month == null) throw new IllegalArgumentException("Month cannot be null.");
        if (day < 0 || day >= month.maxDays) throw new IllegalArgumentException("Day (day="+day+") must be in the range [0;"+(month.maxDays-1)+"]");
    }

    private boolean equals(DayInMonth dom) {
        if (dom.day != day) return false;
        return dom.month.equals(month);
    }
}
