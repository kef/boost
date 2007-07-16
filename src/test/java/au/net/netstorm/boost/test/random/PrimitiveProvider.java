package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.atom.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.test.atom.PrimitiveBoxer;
import au.net.netstorm.boost.test.core.Provider;
import au.net.netstorm.boost.test.core.SpecificProvider;

public final class PrimitiveProvider implements SpecificProvider {
    private final PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private final Provider concretes = new ConcreteRandomProvider();

    public Object provide(Class type) {
        return randomPrimitiveType(type);
    }

    public boolean canProvide(Class type) {
        return primitiveBoxer.isPrimitive(type);
    }

    private Object randomPrimitiveType(Class type) {
        Class boxed = primitiveBoxer.getBoxed(type);
        return concretes.provide(boxed);
    }
}
