package au.net.netstorm.boost.primordial;

public class PrimordialException extends RuntimeException implements BoooostException {
    public PrimordialException(String message) {
        super(message);
    }

    public PrimordialException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
