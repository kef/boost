package au.net.netstorm.boost.sniper.random;

import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.sniper.atom.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.sniper.atom.PrimitiveBoxer;

public final class PrimitiveProvider implements SpecificProvider {
    private final PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private final Provider concretes = new ConcreteRandomProvider();

    public <T> T provide(Class<T> type) {
        if (!canProvide(type)) throw new NotProvidedException(type);
        return randomPrimitiveType(type);
    }

    public boolean canProvide(Class type) {
        return primitiveBoxer.isPrimitive(type);
    }

    private <T> T randomPrimitiveType(Class<T> type) {
        Class<T> boxed = primitiveBoxer.getBoxed(type);
        return concretes.provide(boxed);
    }
}
