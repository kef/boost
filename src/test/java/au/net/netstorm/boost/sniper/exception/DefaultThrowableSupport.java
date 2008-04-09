package au.net.netstorm.boost.sniper.exception;

public class DefaultThrowableSupport implements ThrowableSupport {
    public Throwable translate(Throwable t) {
        return t;
    }
}
