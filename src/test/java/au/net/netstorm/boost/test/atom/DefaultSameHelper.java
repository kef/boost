package au.net.netstorm.boost.test.atom;

final class DefaultSameHelper implements SameHelper {
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();

    public boolean same(Object o1, Object o2) {
        boolean boxed = isBoxed(o1);
        if (boxed) return o1.equals(o2);
        return o1 == o2;
    }

    private boolean isBoxed(Object value) {
        Class cls = value.getClass();
        return primitiveBoxer.isBoxed(cls);
    }
}
