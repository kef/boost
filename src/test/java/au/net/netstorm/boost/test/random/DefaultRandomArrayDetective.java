package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.atom.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.test.atom.PrimitiveBoxer;

public final class DefaultRandomArrayDetective implements RandomArrayDetective {
    private PrimitiveBoxer marquessDeQueensbury = new DefaultPrimitiveBoxer();

    public boolean isRandomizable(Class type) {
        if (!type.isArray()) return false;
        Class componentType = type.getComponentType();
        return marquessDeQueensbury.isPrimitive(componentType);
    }
}
