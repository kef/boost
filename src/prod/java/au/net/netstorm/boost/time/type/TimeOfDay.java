package au.net.netstorm.boost.time.type;

public final class TimeOfDay {

    public static final TimeOfDay MIDNIGHT = new TimeOfDay(HourOfDay.FIRST, MinuteOfHour.FIRST, SecondOfMinute.FIRST);
    public static final TimeOfDay MIDDAY = new TimeOfDay(HourOfDay.MIDDAY , MinuteOfHour.FIRST, SecondOfMinute.FIRST) ;

    public final HourOfDay hour;
    public final MinuteOfHour minute;
    public final SecondOfMinute second;

    public TimeOfDay(HourOfDay hour, MinuteOfHour minute, SecondOfMinute second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        validate();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (! (o instanceof TimeOfDay)) return false;
        return equals((TimeOfDay)o);
    }

    public String toString() {
        return "TimeOfDay[hour="+hour+",minute="+minute+",second="+second+"]";
    }

    public int hashCode() { return 100; }

    // ---- PRIVATE:

    private void validate() {
        if (hour == null) throw new IllegalArgumentException("The hour of the day cannot be null.");
        if (minute == null) throw new IllegalArgumentException("The minute of the hour cannot be null.");
        if (second == null) throw new IllegalArgumentException("The second of the minute cannot be null.");
    }

    private boolean equals(TimeOfDay time) {
        if (! time.hour.equals(hour)) return false;
        if (! time.minute.equals(minute)) return false;
        if (! time.second.equals(second)) return false;
        return true;
    }
}
