package au.net.netstorm.boost.test.random;

public final class EverythingRandomProvider implements RandomProvider {
    private final RandomProvider arrays = new ArrayRandomProvider(this);
    private final RandomProvider primitives = new PrimitiveProvider();
    private final RandomProvider concretes = new ConcreteRandomProvider();
    private final RandomProvider interfaces;

    // FIX 2076 Remove SpecificProviderRegistry.  Moves into RandomInterfaceInvocationHandler.
    // FIX 2076 Pull any specif stuff.  This is just random.
    public EverythingRandomProvider(RandomProvider interfaces) {
        this.interfaces = interfaces;
    }

    // OK CyclomaticComplexity {
    public Object provide(Class type) {
        if (isPrimitive(type)) return primitives.provide(type);
        if (isArray(type)) return arrays.provide(type);
        if (isInterface(type)) return interfaces.provide(type);
        return concretes.provide(type);
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
}
