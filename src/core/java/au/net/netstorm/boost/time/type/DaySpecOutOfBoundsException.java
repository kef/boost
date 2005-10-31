package au.net.netstorm.boost.time.type;

// FIXME: SC501 Test drive exceptions.
public final class DaySpecOutOfBoundsException extends RuntimeException {

    public DaySpecOutOfBoundsException(DaySpec spec, Throwable t) {
        super("Day spec out of range (spec="+spec+"),", t);
    }
}
