package au.net.netstorm.boost.gunge.primitives;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class DefaultPrimitiveBoxer implements PrimitiveBoxer {
    private final Map<Class<?>, Class<?>> primitives = new HashMap<Class<?>, Class<?>>();

    {
        primitives.put(byte.class, Byte.class);
        primitives.put(short.class, Short.class);
        primitives.put(int.class, Integer.class);
        primitives.put(long.class, Long.class);
        primitives.put(float.class, Float.class);
        primitives.put(double.class, Double.class);
        primitives.put(boolean.class, Boolean.class);
        primitives.put(char.class, Character.class);
    }

    public Class convertToBoxed(Class candidate) {
        return isPrimitive(candidate) ? get(candidate) : candidate;
    }

    public Class getBoxed(Class primitive) {
        if (!isPrimitive(primitive)) throw new IllegalArgumentException(primitive + " is not a primitive type");
        return get(primitive);
    }

    public boolean isPrimitive(Class candidate) {
        return candidate.isPrimitive();
    }

    public boolean isBoxed(Class candidate) {
        Collection values = primitives.values();
        return values.contains(candidate);
    }

    private Class get(Class primitive) {
        return primitives.get(primitive);
    }
}
