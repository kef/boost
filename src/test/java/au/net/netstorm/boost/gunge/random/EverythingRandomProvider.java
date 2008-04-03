package au.net.netstorm.boost.gunge.random;

import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.provider.SpecificProvider;

public final class EverythingRandomProvider implements Random {
    private final SpecificProvider arrays = new ArrayRandomProvider(this);
    private final SpecificProvider primitives = new PrimitiveProvider();
    private final SpecificProvider concretes = new ConcreteRandomProvider();
    private final SpecificProvider interfaces;
    private final SpecificProvider enums;

    public EverythingRandomProvider(SpecificProvider interfaces, SpecificProvider enums) {
        this.interfaces = interfaces;
        this.enums = enums;
    }

    // OK CyclomaticComplexity|NCSS|ReturnCount {
    public <T> T provide(Class<T> type) {
        if (isInterface(type)) return interfaces.provide(type);
        if (isEnum(type)) return enums.provide(type);
        if (isPrimitive(type)) return primitives.provide(type);
        if (isArray(type)) return arrays.provide(type);
        if (isConcrete(type)) return concretes.provide(type);
        throw new IllegalStateException("Cannot provide type: " + type);
    }
    // } OK CyclomaticComplexity|NCSS|ReturnCount

    private boolean isInterface(Class type) {
        return interfaces.canProvide(type);
    }

    private boolean isEnum(Class type) {
        return type.isEnum();
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
