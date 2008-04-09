package au.net.netstorm.boost.sniper.atom;

import java.lang.reflect.Array;

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
        Object array = newInstance();
        ArrayHolder result = new DefaultArrayHolder(array);
        for (int i = 0; i < length(); i++) {
            Object value = get(i);
            result.set(i, value);
        }
        return result;
    }

    public Object getArray() {
        return array;
    }

    public int hashCode() {
        return 42;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ArrayHolder)) return false;
        return equals((ArrayHolder) o);
    }

    public boolean equals(ArrayHolder array) {
        return isArraySame(array);
    }

    private boolean isArraySame(ArrayHolder array) {
        if (!sameLength(array)) return false;
        return areElementsSame(array);
    }

    private boolean sameLength(ArrayHolder array) {
        return length() == array.length();
    }

    private boolean areElementsSame(ArrayHolder array) {
        for (int i = 0; i < length(); i++) {
            if (!elementSame(i, array)) return false;
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

    private Object newInstance() {
        Class type = elementType();
        int length = length();
        return Array.newInstance(type, length);
    }
}
