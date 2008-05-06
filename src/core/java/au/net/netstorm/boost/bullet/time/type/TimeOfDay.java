package au.net.netstorm.boost.bullet.time.type;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class TimeOfDay extends Primordial {
    public static final TimeOfDay MIDNIGHT = new TimeOfDay(HourOfDay.FIRST, MinuteOfHour.FIRST, SecondOfMinute.FIRST);
    public static final TimeOfDay MIDDAY = new TimeOfDay(HourOfDay.MIDDAY, MinuteOfHour.FIRST, SecondOfMinute.FIRST);
    public final HourOfDay hour;
    public final MinuteOfHour minute;
    public final SecondOfMinute second;

    public TimeOfDay(HourOfDay hour, MinuteOfHour minute, SecondOfMinute second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        validate();
    }

    private void validate() {
        if (hour == null) throw new IllegalArgumentException("The hour of the day cannot be null.");
        if (minute == null) throw new IllegalArgumentException("The minute of the hour cannot be null.");
        if (second == null) throw new IllegalArgumentException("The second of the minute cannot be null.");
    }
}
