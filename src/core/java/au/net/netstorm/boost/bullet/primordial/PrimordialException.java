package au.net.netstorm.boost.bullet.primordial;

public class PrimordialException extends RuntimeException implements BoooostException {
    public PrimordialException(String message) {
        super(message);
    }

    public PrimordialException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
