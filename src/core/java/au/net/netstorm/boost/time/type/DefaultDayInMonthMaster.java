package au.net.netstorm.boost.time.type;

// FIX SC507 Remove all -- PRIVATE comments.
// FIX SC507 Instancise all static utilities.  Call masters?
// FIX SC502 Interface?
public final class DefaultDayInMonthMaster implements DayInMonthMaster {
    public final DayInMonth incMonth(DayInMonth dim) {
        return bumpMonth(dim, +1);
    }

    public final DayInMonth decMonth(DayInMonth dim) {
        return bumpMonth(dim, -1);
    }

    public final DayInMonth incDay(DayInMonth dim) {
        return bumpDay(dim, +1);
    }

    public final DayInMonth decDay(DayInMonth dim) {
        return bumpDay(dim, -1);
    }

    public final DayInMonth bumpDay(DayInMonth dim, int amount) {
        return new DayInMonth(modulo(dim.day + amount, dim.month.maxDays), dim.month);
    }

    public final DayInMonth bumpMonth(DayInMonth dim, int amount) {
        MonthOfYear month = new MonthOfYear(modulo(dim.month.value + amount, MonthOfYear.MONTHS_IN_YEAR));
        int day = Math.min(dim.day, (month.maxDays - 1));
        return new DayInMonth(day, month);
    }

    public final int modulo(int value, int mod) {
        return (value + mod) % mod;
    }
}
