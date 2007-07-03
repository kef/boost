package au.net.netstorm.boost.test.exception;

public class DefaultExceptionSupport implements ExceptionSupport {
    public RuntimeException translate(RuntimeException e) {
        return e;
    }
}
