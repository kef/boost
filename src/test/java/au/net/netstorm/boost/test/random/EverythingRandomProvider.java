package au.net.netstorm.boost.test.random;

public final class EverythingRandomProvider implements RandomProvider {
    private final RandomProvider arrays = new ArrayRandomProvider(this);
    private final RandomProvider primitives = new PrimitiveProvider();
    private final RandomProvider concretes = new ConcreteRandomProvider();
    private final RandomProvider interfaces;

    // FIX 2076 Pass in as array of providers.
    public EverythingRandomProvider(RandomProvider interfaces) {
        this.interfaces = interfaces;
    }

    // OK CyclomaticComplexity {
    public Object provide(Class type) {
        if (isInterface(type)) return interfaces.provide(type);
        if (isPrimitive(type)) return primitives.provide(type);
        if (isArray(type)) return arrays.provide(type);
        if (isConcrete(type)) return concretes.provide(type);
        throw new IllegalStateException("Cannot provide type: " + type);
    }

    // } OK CyclomaticComplexity

    public boolean canProvide(Class type) {
        return true;
    }

    private boolean isPrimitive(Class type) {
        return primitives.canProvide(type);
    }

    private boolean isArray(Class type) {
        return arrays.canProvide(type);
    }

    private boolean isInterface(Class type) {
        return interfaces.canProvide(type);
    }

    private boolean isConcrete(Class type) {
        return concretes.canProvide(type);
    }
}
