package au.net.netstorm.boost.bullet.time.type;

// FIX SC507 Remove all -- PRIVATE comments.
// FIX SC507 Instancise all static utilities.  Call masters?

// FIX SC502 Interface?
public final class DefaultDayInMonthMaster implements DayInMonthMaster {
    public DayInMonth incMonth(DayInMonth dim) {
        return bumpMonth(dim, +1);
    }

    public DayInMonth decMonth(DayInMonth dim) {
        return bumpMonth(dim, -1);
    }

    public DayInMonth incDay(DayInMonth dim) {
        return bumpDay(dim, +1);
    }

    public DayInMonth decDay(DayInMonth dim) {
        return bumpDay(dim, -1);
    }

    public DayInMonth bumpDay(DayInMonth dim, int amount) {
        return new DayInMonth(modulo(dim.day + amount, dim.month.maxDays), dim.month);
    }

    public DayInMonth bumpMonth(DayInMonth dim, int amount) {
        MonthOfYear month = new MonthOfYear(modulo(dim.month.value + amount, MonthOfYear.MONTHS_IN_YEAR));
        int day = Math.min(dim.day, (month.maxDays - 1));
        return new DayInMonth(day, month);
    }

    public int modulo(int value, int mod) {
        return (value + mod) % mod;
    }
}
