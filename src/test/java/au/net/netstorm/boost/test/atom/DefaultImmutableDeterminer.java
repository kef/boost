package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.type.Immutable;

public final class DefaultImmutableDeterminer implements ImmutableDeterminer {
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();

    public boolean isImmutable(Class cls) {
        if (implementsImmutable(cls)) return true;
        if (isPrimitive(cls)) return true;
        return isBoxedPrimitive(cls);
    }

    private boolean isBoxedPrimitive(Class cls) {
        return primitiveBoxer.isBoxed(cls);
    }

    private boolean isPrimitive(Class cls) {
        return primitiveBoxer.isPrimitive(cls);
    }

    private boolean implementsImmutable(Class cls) {
        return Immutable.class.isAssignableFrom(cls);
    }
}
