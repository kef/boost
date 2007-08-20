package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.time.core.DefaultTimePoint;
import au.net.netstorm.boost.time.core.TimePoint;

public final class DefaultStartEndResolver implements StartEndResolver {
    private static final TimeHelper HELPER = new DefaultTimeHelper();
    private static final TimeType ABSOLUTE = TimeType.ABSOLUTE;
    private static final TimeType RELATIVE = TimeType.RELATIVE;
    private static final TimeType NONE = TimeType.NONE;
    private static final TimePoint ARMAGEDDON = DefaultTimePoint.ARMAGEDDON;

    public TimePeriod get(StartEnd times, TimePoint now) {
        TimeSpec sSpec = times.getStart();
        TimeSpec eSpec = times.getEnd();
        TimePoint sPoint = calc(sSpec, now);
        TimePoint ePoint = calc(eSpec, sPoint);
        return new DefaultTimePeriod(sPoint, ePoint);
    }

    // FIX 1914 This is THE MEAT.  Move out into separate class so everyone can use.
    // FIX 1914 TimeSpec resolver/converter.
    private TimePoint calc(TimeSpec time, TimePoint anchor) {
        TimeType type = time.getType();
        if (type.equals(ABSOLUTE)) return time.getAbsolute();
        if (type.equals(RELATIVE)) return relative(time, anchor);
        if (type.equals(NONE)) return ARMAGEDDON;
        throw new UnsupportedOperationException("" + type);
    }

    private TimePoint relative(TimeSpec time, TimePoint anchor) {
        Relative relative = time.getRelative();
        long offset = relative.getOffset();
        return HELPER.beyond(anchor, offset);
    }
}
