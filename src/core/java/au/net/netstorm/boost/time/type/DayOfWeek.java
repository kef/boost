package au.net.netstorm.boost.time.type;

import java.util.Calendar;

// FIX SC502 Candidate for Primordial with specialised toString().
public final class DayOfWeek {

    public static final int DAYS_IN_A_WEEK = 7;

    public final int value;

    public DayOfWeek(int day) {
        value = day;
        validate();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (! (o instanceof DayOfWeek)) return false;
        return ((DayOfWeek)o).value == value;
    }

    public int hashCode() { return 100; }

    public String toString() {
        if (value == Calendar.SUNDAY) return "SUNDAY";
        if (value == Calendar.MONDAY) return "MONDAY";
        if (value == Calendar.TUESDAY) return "TUESDAY";
        if (value == Calendar.WEDNESDAY) return "WEDNESDAY";
        if (value == Calendar.THURSDAY) return "THURSDAY";
        if (value == Calendar.FRIDAY) return "FRIDAY";
        return "SATURDAY";
    }

    private void validate() {
        if (value < Calendar.SUNDAY || value > Calendar.SATURDAY) throw new IllegalArgumentException("Invalid day (day="+value+").");
    }

    // FIX SC507 Move this into "edge" and reference.
    static final void jdkCalendarCheck() {
        // Sanity check.  The logic of this class is based on assumption of the following.
        if (Calendar.SUNDAY    != 1) throw new IllegalStateException("Expected Calendar.SUNDAY to be 1, instead it was "+Calendar.SUNDAY);
        if (Calendar.MONDAY    != 2) throw new IllegalStateException("Expected Calendar.MONDAY to be 2, instead it was "+Calendar.MONDAY);
        if (Calendar.TUESDAY   != 3) throw new IllegalStateException("Expected Calendar.TUESDAY to be 3, instead it was "+Calendar.TUESDAY);
        if (Calendar.WEDNESDAY != 4) throw new IllegalStateException("Expected Calendar.WEDNESDAY to be 4, instead it was "+Calendar.WEDNESDAY);
        if (Calendar.THURSDAY  != 5) throw new IllegalStateException("Expected Calendar.THURSDAY to be 5, instead it was "+Calendar.THURSDAY);
        if (Calendar.FRIDAY    != 6) throw new IllegalStateException("Expected Calendar.FRIDAY to be 6, instead it was "+Calendar.FRIDAY);
        if (Calendar.SATURDAY  != 7) throw new IllegalStateException("Expected Calendar.SATURDAY to be 7, instead it was "+Calendar.SATURDAY);
    }

    static { jdkCalendarCheck(); };
}
