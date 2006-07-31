package au.net.netstorm.boost.reflect;

// FIX SC502 Need some code which ensures there is a corresponding Atomic test for each class.
// FIX SC502 Test drive this.

public class InterfaceNotClassException extends RuntimeException {
    public InterfaceNotClassException(Class cls) {
        super(cls.toString());
    }
}