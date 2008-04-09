package au.net.netstorm.boost.bullet.mirror;

public class InterfaceNotClassException extends RuntimeException {
    public InterfaceNotClassException(Class cls) {
        super("" + cls);
    }
}