package au.net.netstorm.boost.test.exception;

public class DefaultThrowableSupport implements ThrowableSupport {
    public Throwable translate(Throwable t) {
        return t;
    }
}
