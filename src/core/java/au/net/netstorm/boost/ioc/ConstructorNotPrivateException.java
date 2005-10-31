package au.net.netstorm.boost.ioc;

public class ConstructorNotPrivateException extends IocException {
    public ConstructorNotPrivateException(Class cls) {
        super("Single constructor must be private in " + cls, null);
    }
}
