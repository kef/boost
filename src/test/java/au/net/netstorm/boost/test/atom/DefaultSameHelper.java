package au.net.netstorm.boost.test.atom;

final class DefaultSameHelper implements SameHelper {
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();

    public boolean same(Object o1, Object o2) {
        if (isArray(o1)) return isArraySame(o1, o2);
        return isNonArraySame(o1, o2);
    }

    private boolean isArraySame(Object o1, Object o2) {
        Object[] a1 = (Object[]) o1;
        Object[] a2 = (Object[]) o2;
        if (sameLength(a1, a2)) return false;
        for (int i = 0; i < a1.length; i++) {
            if (!same(a1[i], a2[i])) return false;
        }
        return true;
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

    private boolean sameLength(Object[] array1, Object[] array2) {
        return array1.length != array2.length;
    }
}
