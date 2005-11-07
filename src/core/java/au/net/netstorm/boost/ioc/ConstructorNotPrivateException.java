package au.net.netstorm.boost.ioc;

// FIXME: SC502 Do we need this stuff at the moment?
public class ConstructorNotPrivateException extends IocException {
    public ConstructorNotPrivateException(Class cls) {
        super("Single constructor must be private in " + cls, null);
    }
}
