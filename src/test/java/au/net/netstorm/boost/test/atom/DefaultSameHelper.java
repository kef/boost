package au.net.netstorm.boost.test.atom;

final class DefaultSameHelper implements SameHelper {
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();

    public boolean same(Object o1, Object o2) {
        if (isArray(o1)) return isArraySame(o1, o2);
        return isNonArraySame(o1, o2);
    }

    // FIX 525 Tidy this up.
    private boolean isArraySame(Object o1, Object o2) {
        if (!isArray(o2)) return false;
        ArrayHolder arrayHolder2 = new DefaultArrayHolder(o2);
        ArrayHolder arrayHolder1 = new DefaultArrayHolder(o1);
        return arrayHolder1.foo(arrayHolder2);
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

}
