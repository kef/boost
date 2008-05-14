package au.net.netstorm.boost.sniper.random;

import au.net.netstorm.boost.gunge.primitives.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.gunge.primitives.PrimitiveBoxer;

public final class DefaultRandomArrayDetective implements RandomArrayDetective {
    private PrimitiveBoxer marquessDeQueensbury = new DefaultPrimitiveBoxer();

    public boolean isRandomizable(Class type) {
        if (!type.isArray()) return false;
        Class componentType = type.getComponentType();
        return marquessDeQueensbury.isPrimitive(componentType);
    }
}
