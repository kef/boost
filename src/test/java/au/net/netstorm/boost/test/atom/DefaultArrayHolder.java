package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Array;

// FIX 525 Implement all methods.
// FIX 525 Implement clone().
// FIX 525 Stitch into existing test code.
final class DefaultArrayHolder implements ArrayHolder {
    private final Object array;

    public DefaultArrayHolder(Object array) {
        this.array = array;
        validate();
    }

    public int length() {
        return Array.getLength(array);
    }

    public Object get(int index) {
        return Array.get(array, index);
    }

    public void set(int index, Object value) {
        Array.set(array, index, value);
    }

    public Class elementType() {
        Class cls = array.getClass();
        return cls.getComponentType();
    }

    private void validate() {
        Class cls = array.getClass();
        boolean isArray = cls.isArray();
        if (!isArray) throw new IllegalStateException(cls + " is not an array.");
    }
}
