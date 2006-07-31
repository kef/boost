package au.net.netstorm.boost.time.type;

// FIX SC502 Candidate for Primordial with ability to override toString().
public final class MonthOfYear {

    public static final int MONTHS_IN_YEAR = 12;
    public static final MonthOfYear JANUARY = new MonthOfYear(0);
    public static final MonthOfYear FEBRUARY = new MonthOfYear(1);
    public static final MonthOfYear MARCH = new MonthOfYear(2);
    public static final MonthOfYear APRIL = new MonthOfYear(3);
    public static final MonthOfYear MAY = new MonthOfYear(4);
    public static final MonthOfYear JUNE = new MonthOfYear(5);
    public static final MonthOfYear JULY = new MonthOfYear(6);
    public static final MonthOfYear AUGUST = new MonthOfYear(7);
    public static final MonthOfYear SEPTEMBER = new MonthOfYear(8);
    public static final MonthOfYear OCTOBER = new MonthOfYear(9);
    public static final MonthOfYear NOVEMBER = new MonthOfYear(10);
    public static final MonthOfYear DECEMBER = new MonthOfYear(11);
    public final int value;
    public final int maxDays;

    public MonthOfYear(int month) {
        this.value = month;
        validate();
        this.maxDays = maxDays();
    }

    public boolean equals(Object o) {
        if (!(o instanceof MonthOfYear)) return false;
        return ((MonthOfYear)o).value == value;
    }

    public int hashCode() {
        return 100;
    }

    public String toString() {
        return "" + toString(value);
    }

    private void validate() {
        if (value < 0 || value >= MONTHS_IN_YEAR) throw new IllegalArgumentException("Invalid month (month="+value+").  Month must be between 0 and "+(MONTHS_IN_YEAR-1)+".");
    }

    private int maxDays() {
        if (value == 1) return 29;
        if (value == 3 || value == 5 || value == 8 || value == 10) return 30;
        return 31;
    }

    private String toString(int value) {
        return STRINGS[value];
    }

    private static final String[] STRINGS = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
}
