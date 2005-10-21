package au.net.netstorm.boost.time.type;

// FIXME: SC501 Remove all -- PRIVATE comments.
// FIXME: SC501 Instancise all static utilities.  Call masters?
public final class DayInMonthUtil {

    public static final DayInMonth incMonth(DayInMonth dim) {
        return bumpMonth(dim, +1);
    }

    public static final DayInMonth decMonth(DayInMonth dim) {
        return bumpMonth(dim, -1);
    }

    public static final DayInMonth incDay(DayInMonth dim) {
        return bumpDay(dim, +1);
    }

    public static final DayInMonth decDay(DayInMonth dim) {
        return bumpDay(dim, -1);
    }

    private static final DayInMonth bumpDay(DayInMonth dim, int amount) {
        return new DayInMonth(modulo(dim.day + amount, dim.month.maxDays), dim.month);
    }

    private static final DayInMonth bumpMonth(DayInMonth dim, int amount) {
        MonthOfYear month = new MonthOfYear(modulo(dim.month.value + amount, MonthOfYear.MONTHS_IN_YEAR));
        int day = Math.min(dim.day, (month.maxDays - 1));
        return new DayInMonth(day, month);
    }

    private static final int modulo(int value, int mod) {
        return (value + mod) % mod;
    }
}
