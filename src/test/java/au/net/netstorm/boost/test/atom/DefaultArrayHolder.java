package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Array;

// FIX 525 Implement all methods.
// FIX 525 Implement clone().
// FIX 525 Stitch into existing test code.
// FIX 525 Order methods.
final class DefaultArrayHolder implements ArrayHolder {
    private SameHelper sameHelper = new DefaultSameHelper();
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

    public Object clone() {
        Object result = newInstance();
        for (int i = 0; i < length(); i++) {
            Object value = Array.get(array, i);
            Array.set(result, i, value);
        }
        return new DefaultArrayHolder(result);
    }

    public Object getArray() {
        return array;
    }

    public boolean foo(ArrayHolder array) {
        return isArraySame(array);
    }

    private boolean isArraySame(ArrayHolder a2) {
        if (!sameLength(a2)) return false;
        return areElementsSame(a2);
    }

    private boolean sameLength(ArrayHolder a2) {
        return length() == a2.length();
    }

    private boolean areElementsSame(ArrayHolder a2) {
        int length = length();
        for (int i = 0; i < length; i++) {
            if (!elementSame(i, a2)) return false;
        }
        return true;
    }

    private boolean elementSame(int i, ArrayHolder a2) {
        Object x1 = get(i);
        Object x2 = a2.get(i);
        return sameHelper.same(x1, x2);
    }

    private void validate() {
        Class cls = array.getClass();
        boolean isArray = cls.isArray();
        if (!isArray) throw new IllegalStateException(cls + " is not an array.");
    }

    // FIX 525 Push this out through the interface.
    private Object newInstance() {
        Class type = elementType();
        int length = length();
        return Array.newInstance(type, length);
    }
}
