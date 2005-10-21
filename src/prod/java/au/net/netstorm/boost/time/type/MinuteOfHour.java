package au.net.netstorm.boost.time.type;

public final class MinuteOfHour {

    public static final int MINUTES_IN_HOUR = 60;
    public static final MinuteOfHour FIRST = new MinuteOfHour(0);

    public final int value;

    public MinuteOfHour(int minute) {
        value = minute;
        validate();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (! (o instanceof MinuteOfHour)) return false;
        return ((MinuteOfHour)o).value == value;
    }

    public int hashCode() { return 100; }

    public String toString() {
        return ""+value;
    }

    // ---- PRIVATE:

    private void validate() {
        if (value < 0 || value >= MINUTES_IN_HOUR) throw new IllegalArgumentException("Invalid minute (minute="+value+").");
    }
}
