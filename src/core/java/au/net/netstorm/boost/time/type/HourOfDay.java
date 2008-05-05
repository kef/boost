package au.net.netstorm.boost.time.type;

import au.net.netstorm.boost.bullet.primmm.Primordial;

public final class HourOfDay extends Primordial {
    public static final int HOURS_IN_A_DAY = 24;
    public static final HourOfDay FIRST = new HourOfDay(0);
    public static final HourOfDay MIDNIGHT = FIRST;
    public static final HourOfDay MIDDAY = new HourOfDay(12);
    public final int value;

    public HourOfDay(int hour) {
        value = hour;
        validate();
    }

    private void validate() {
        if (value < 0 || value >= HOURS_IN_A_DAY)
            throw new IllegalArgumentException("Invalid hour (hour=" + value + ").");
    }
}
