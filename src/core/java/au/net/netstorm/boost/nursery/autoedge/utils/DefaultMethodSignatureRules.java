package au.net.netstorm.boost.nursery.autoedge.utils;

public class DefaultMethodSignatureRules implements MethodSignatureRules {
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

    // FIX 2328 handle primitives ??
    private boolean assignable(Class<?> lhs, Class<?> rhs) {
        return lhs.isAssignableFrom(rhs);
    }

}
