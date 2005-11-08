package au.net.netstorm.boost.time.type;

public interface DayInMonthMaster {
    DayInMonth incMonth(DayInMonth dim);

    DayInMonth decMonth(DayInMonth dim);

    DayInMonth incDay(DayInMonth dim);

    DayInMonth decDay(DayInMonth dim);

    DayInMonth bumpDay(DayInMonth dim, int amount);

    DayInMonth bumpMonth(DayInMonth dim, int amount);

    int modulo(int value, int mod);
}
