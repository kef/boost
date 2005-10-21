package au.net.netstorm.boost.ioc;

public class IocException extends RuntimeException {
    public IocException(String message, Throwable t) {
        super(message, t);
    }

    public IocException(String message) {
        super(message);
    }
}
