package au.net.netstorm.boost.gunge.reflect;

import java.util.HashMap;
import java.util.Map;

public class DefaultMethodSignatureRules implements MethodSignatureRules {
    // FIX 2328 might be useful somewhere else
    // FIX 2328 MAG Pretty sure this lives in the data atomic test area somewhere.
    // FIX 2328 MAG the randomiser stuff?
    // FIX 2328 Just had a look.  PrimitiveBoxer.  Discuss.
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
        return primitives.containsKey(unboxed) ? primitives.get(unboxed) : unboxed;
    }
}
