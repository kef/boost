package au.net.netstorm.boost.sniper.random;

import au.net.netstorm.boost.sniper.atom.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.sniper.atom.PrimitiveBoxer;

public final class DefaultRandomArrayDetective implements RandomArrayDetective {
    private PrimitiveBoxer marquessDeQueensbury = new DefaultPrimitiveBoxer();

    public boolean isRandomizable(Class type) {
        if (!type.isArray()) return false;
        Class componentType = type.getComponentType();
        return marquessDeQueensbury.isPrimitive(componentType);
    }
}
