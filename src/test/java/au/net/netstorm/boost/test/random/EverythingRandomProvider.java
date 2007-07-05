package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.atom.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.test.atom.PrimitiveBoxer;
import au.net.netstorm.boost.test.specific.SpecificProviderRegistry;

public final class EverythingRandomProvider implements RandomProvider {
    private final PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private final RandomProvider concretes = new ConcreteRandomProvider();
    private final RandomProvider arrays = new ArrayRandomProvider(this);
    private final RandomProvider interfaces;

    // FIX 2076 Remove SpecificProviderRegistry.  Moves into RandomInterfaceInvocationHandler.
    // FIX 2076 Pull any specif stuff.  This is just random.
    public EverythingRandomProvider(SpecificProviderRegistry specifics) {
        interfaces = new InterfaceRandomProvider(this, specifics);
    }

    // OK CyclomaticComplexity {
    public Object get(Class type) {
        if (isInterface(type)) return randomInterface(type);
        if (isPrimitive(type)) return randomPrimitiveType(type);
        if (isArray(type)) return randomArray(type);
        return randomSupportedConcrete(type);
    }

    // } OK CyclomaticComplexity

    private boolean isInterface(Class type) {
        return type.isInterface();
    }

    private boolean isPrimitive(Class type) {
        return primitiveBoxer.isPrimitive(type);
    }

    private boolean isArray(Class type) {
        return type.isArray();
    }

    private Object randomInterface(Class type) {
        return interfaces.get(type);
    }

    private Object randomPrimitiveType(Class type) {
        Class boxed = primitiveBoxer.getBoxed(type);
        return concretes.get(boxed);
    }

    private Object randomSupportedConcrete(Class type) {
        return concretes.get(type);
    }

    private Object randomArray(Class type) {
        return arrays.get(type);
    }
}
