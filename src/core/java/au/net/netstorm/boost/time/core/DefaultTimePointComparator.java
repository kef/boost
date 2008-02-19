package au.net.netstorm.boost.time.core;

public final class DefaultTimePointComparator implements TimePointComparator {
    public int compare(Object o1, Object o2) {
        TimePoint t1 = (TimePoint) o1;
        TimePoint t2 = (TimePoint) o2;
        return compare(t1, t2);
    }

    private int compare(TimePoint t1, TimePoint t2) {
        if (t1.equals(t2)) return 0;
        if (t1.before(t2)) return -1;
        return 1;
    }
}
