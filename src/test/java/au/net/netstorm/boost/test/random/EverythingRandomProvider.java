package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.core.Provider;
import au.net.netstorm.boost.test.core.SpecificProvider;

public final class EverythingRandomProvider implements Provider {
    private final SpecificProvider arrays = new ArrayRandomProvider(this);
    private final SpecificProvider primitives = new PrimitiveProvider();
    private final SpecificProvider concretes = new ConcreteRandomProvider();
    private final SpecificProvider interfaces;

    public EverythingRandomProvider(SpecificProvider interfaces) {
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

    private boolean isInterface(Class type) {
        return interfaces.canProvide(type);
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
