package au.net.netstorm.boost.nursery.util;

public final class DefaultObjectRef implements ObjectRef {
    private final Object obj;

    public DefaultObjectRef(Object obj) {
        this.obj = obj;
    }

    public boolean exists() {
        return obj != null;
    }

    public Object get() {
        if (!exists()) throw new IllegalArgumentException("Cannot reference the object because is does not exist.");
        return obj;
    }
}
