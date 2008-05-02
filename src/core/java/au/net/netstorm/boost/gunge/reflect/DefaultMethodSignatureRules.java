package au.net.netstorm.boost.gunge.reflect;

import java.util.HashMap;
import java.util.Map;

public class DefaultMethodSignatureRules implements MethodSignatureRules {
    // FIX 2328 might be useful somewhere else
    private static final Map<Class<?>,Class<?>> PRIMITIVES = new HashMap<Class<?>,Class<?>>();
    static {
        PRIMITIVES.put(byte.class, Byte.class);
        PRIMITIVES.put(short.class, Short.class);
        PRIMITIVES.put(int.class, Integer.class);
        PRIMITIVES.put(long.class, Long.class);
        PRIMITIVES.put(float.class, Float.class);
        PRIMITIVES.put(double.class, Double.class);
        PRIMITIVES.put(boolean.class, Boolean.class);
        PRIMITIVES.put(char.class, Character.class);
    }

    public boolean compatible(Class<?>[] target, Class<?>[] canIBeAssignedToTarget) {
        if (target.length != canIBeAssignedToTarget.length) return false;
        for (int i = 0; i < target.length; ++i) {
            if (!assignable(target[i], canIBeAssignedToTarget[i])) return false;
        }
        return true;
    }

    public boolean moreSpecific(Class<?>[] target, Class<?>[] amIMoreSpecificThanTarget) {
        return compatible(target, amIMoreSpecificThanTarget) && !compatible(amIMoreSpecificThanTarget, target);
    }

    private boolean assignable(Class<?> lhs, Class<?> rhs) {
        Class<?> boxedLeft = box(lhs);
        Class<?> boxedRight = box(rhs);
        return boxedLeft.isAssignableFrom(boxedRight);
    }

    private Class<?> box(Class<?> unboxed) {
        return PRIMITIVES.containsKey(unboxed) ? PRIMITIVES.get(unboxed) : unboxed;
    }
}
