package au.net.netstorm.boost.edge;

// FIXME: SC043 Checkstyle pattern to exclude RuntimeException.
// FIXME: SC043 Remove the INSTANCE (or EDGE_CONSTRUCTOR) stuff.
// FIXME: SC043 Turn off simian checks.

public final class EdgeException extends RuntimeException {
    public EdgeException(Throwable throwable) {
        super(throwable);
    }
}
