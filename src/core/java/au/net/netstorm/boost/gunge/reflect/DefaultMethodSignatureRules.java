package au.net.netstorm.boost.gunge.reflect;

import au.net.netstorm.boost.gunge.primitives.PrimitiveBoxer;

public class DefaultMethodSignatureRules implements MethodSignatureRules {
    PrimitiveBoxer boxer;

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
        Class<?> boxedLeft = boxer.convertToBoxed(lhs);
        Class<?> boxedRight = boxer.convertToBoxed(rhs);
        return boxedLeft.isAssignableFrom(boxedRight);
    }
}
