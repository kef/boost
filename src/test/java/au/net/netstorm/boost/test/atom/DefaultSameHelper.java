package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Array;

// FIX 525 Stitch in ArrayHelper.
final class DefaultSameHelper implements SameHelper {
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();

    public boolean same(Object o1, Object o2) {
        if (isArray(o1)) return isArraySame(o1, o2);
        return isNonArraySame(o1, o2);
    }

    private boolean isArraySame(Object a1, Object a2) {
        if (!isArray(a2)) return false;
        if (!sameLength(a1, a2)) return false;
        return areElementsSame(a1, a2);
    }

    private boolean sameLength(Object a1, Object a2) {
        return length(a1) == length(a2);
    }

    private boolean areElementsSame(Object a1, Object a2) {
        int length = length(a1);
        for (int i = 0; i < length; i++) {
            if (!elementSame(i, a1, a2)) return false;
        }
        return true;
    }

    private boolean elementSame(int i, Object a1, Object a2) {
        Object x1 = get(a1, i);
        Object x2 = get(a2, i);
        return same(x1, x2);
    }

    private boolean isArray(Object ref) {
        Class type = ref.getClass();
        return type.isArray();
    }

    private boolean isNonArraySame(Object o1, Object o2) {
        boolean boxed = isBoxed(o1);
        if (boxed) return o1.equals(o2);
        return o1 == o2;
    }

    private boolean isBoxed(Object value) {
        Class cls = value.getClass();
        return primitiveBoxer.isBoxed(cls);
    }

    private Object get(Object array, int i) {
        return Array.get(array, i);
    }

    private int length(Object array) {
        return Array.getLength(array);
    }
}
