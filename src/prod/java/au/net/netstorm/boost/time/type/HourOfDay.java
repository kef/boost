package au.net.netstorm.boost.time.type;

public final class HourOfDay {

    public static final int HOURS_IN_A_DAY = 24;
    public static final HourOfDay FIRST = new HourOfDay(0);
    public static final HourOfDay MIDNIGHT = FIRST;
    public static final HourOfDay MIDDAY = new HourOfDay(12);

    public final int value;

    public HourOfDay(int hour) {
        value = hour;
        validate();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof HourOfDay)) return false;
        return ((HourOfDay)o).value == value;

    }

    public int hashCode() { return 100; }

    public String toString() {
        return ""+value;
    }

    // -------- PRIVATE:

    private void validate() {
        if (value < 0 || value >= HOURS_IN_A_DAY) throw new IllegalArgumentException("Invalid hour (hour="+value+").");
    }
}
