package au.net.netstorm.boost.util.reflect;

// FIXME: SC502 Atomic test.
public final class RuntimeClassNotFoundException extends RuntimeException {
    public RuntimeClassNotFoundException(ClassNotFoundException e) {
        super(e);
    }
}
