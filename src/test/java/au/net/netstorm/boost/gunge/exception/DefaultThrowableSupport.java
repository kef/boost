package au.net.netstorm.boost.gunge.exception;

public class DefaultThrowableSupport implements ThrowableSupport {
    public Throwable translate(Throwable t) {
        return t;
    }
}
