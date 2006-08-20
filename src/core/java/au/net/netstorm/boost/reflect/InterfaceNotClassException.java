package au.net.netstorm.boost.reflect;

public class InterfaceNotClassException extends RuntimeException {
    public InterfaceNotClassException(Class cls) {
        super(cls.toString());
    }
}