package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.core.Provider;

public final class EverythingRandomProvider implements Provider {
    private final Provider arrays = new ArrayRandomProvider(this);
    private final Provider primitives = new PrimitiveProvider();
    private final Provider concretes = new ConcreteRandomProvider();
    private final Provider interfaces;

    public EverythingRandomProvider(Provider interfaces) {
        this.interfaces = interfaces;
    }

    // OK CyclomaticComplexity {
    public Object provide(Class type) {
        if (interfaces.canProvide(type)) return interfaces.provide(type);
        if (isPrimitive(type)) return primitives.provide(type);
        if (isArray(type)) return arrays.provide(type);
        if (isConcrete(type)) return concretes.provide(type);
        throw new IllegalStateException("Cannot provide type: " + type);
    }
    // } OK CyclomaticComplexity

    // FIX 2076 Get rid of this.

    public boolean canProvide(Class type) {
        return true;
    }

    private boolean isPrimitive(Class type) {
        return primitives.canProvide(type);
    }

    private boolean isArray(Class type) {
        return arrays.canProvide(type);
    }

    private boolean isConcrete(Class type) {
        return concretes.canProvide(type);
    }
}
