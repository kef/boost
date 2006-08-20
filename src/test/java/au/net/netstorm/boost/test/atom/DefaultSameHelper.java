package au.net.netstorm.boost.test.atom;

final class DefaultSameHelper implements SameHelper {
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();

    public boolean same(Object o1, Object o2) {
        if (isArray(o1)) return isArraySame(o1, o2);
        return isSame(o1, o2);
    }

    private boolean isArraySame(Object o1, Object o2) {
        Object[] array1 = (Object[]) o1;
        Object[] array2 = (Object[]) o2;
        int length = array1.length;
        if (length != array2.length) return false;
        for (int i = 0; i < length; i++) {
            if (!isSame(array1[i], array2[i])) return false;
        }
        return true;
    }

    private boolean isArray(Object ref) {
        Class type = ref.getClass();
        return type.isArray();
    }

    private boolean isSame(Object o1, Object o2) {
        boolean boxed = isBoxed(o1);
        if (boxed) return o1.equals(o2);
        return o1 == o2;
    }

    private boolean isBoxed(Object value) {
        Class cls = value.getClass();
        return primitiveBoxer.isBoxed(cls);
    }
}
