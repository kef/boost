package au.net.netstorm.boost.sledge.support;

public final class EdgeException extends RuntimeException {
    public EdgeException(Throwable throwable) {
        super(throwable);
    }

    public EdgeException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
