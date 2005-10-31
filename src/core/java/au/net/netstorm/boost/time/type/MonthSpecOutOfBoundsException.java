package au.net.netstorm.boost.time.type;

public final class MonthSpecOutOfBoundsException extends RuntimeException {

    public MonthSpecOutOfBoundsException(MonthSpec spec, Throwable t) {
        super("Month spec out of range (spec="+spec+"),", t);
    }
}
