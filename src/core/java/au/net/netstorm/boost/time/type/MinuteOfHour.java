package au.net.netstorm.boost.time.type;

import au.net.netstorm.boost.primordial.Primordial;

public final class MinuteOfHour extends Primordial {

    public static final int MINUTES_IN_HOUR = 60;
    public static final MinuteOfHour FIRST = new MinuteOfHour(0);

    public final int value;

    public MinuteOfHour(int minute) {
        value = minute;
        validate();
    }

    private void validate() {
        if (value < 0 || value >= MINUTES_IN_HOUR) throw new IllegalArgumentException("Invalid minute (minute="+value+").");
    }
}
