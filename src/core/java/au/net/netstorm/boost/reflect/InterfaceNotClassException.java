package au.net.netstorm.boost.reflect;

// FIXME: SC502 Need some code which ensures there is a corresponding Atomic test for each class.
// FIXME: SC502 Test drive this.

public class InterfaceNotClassException extends RuntimeException {
    public InterfaceNotClassException(Class cls) {
        super(cls.toString());
    }
}