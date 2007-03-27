package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.atom.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.test.atom.PrimitiveBoxer;

public final class EverythingRandomProvider implements RandomProvider {
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private RandomProvider concretes = new ConcreteRandomProvider();
    private RandomProvider arrays = new ArrayRandomProvider(this);
    private RandomProvider interfaces = new InterfaceRandomProvider();

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
