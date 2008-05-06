package au.net.netstorm.boost.edge;

public final class EdgeException extends RuntimeException {
    public EdgeException(Throwable throwable) {
        super(throwable);
    }

    public EdgeException(String message, Throwable throwable) {
        super(message, throwable);
    }

    // FIX 2328 Do not expose this just for tests.
    // FIX 2318 Use ThrowableMaster?
    public boolean causeIs(Class type) {
        Throwable cause = getCause();
        if (cause == null) {
            return type == null;
        }
        Class causeCls = cause.getClass();
        return causeCls.equals(type);
    }
}
