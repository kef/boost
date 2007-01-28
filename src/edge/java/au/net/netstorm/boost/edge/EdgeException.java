package au.net.netstorm.boost.edge;

public final class EdgeException extends RuntimeException {
    public EdgeException(Throwable throwable) {
        super(throwable);
    }

    public boolean causeIs(Class type) {
        Throwable cause = getCause();
        if (cause == null) {
            return type == null;
        }
        Class causeCls = cause.getClass();
        return causeCls.equals(type);
    }
}
