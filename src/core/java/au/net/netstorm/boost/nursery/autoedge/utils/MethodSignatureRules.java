package au.net.netstorm.boost.nursery.autoedge.utils;


public interface MethodSignatureRules {
    boolean compatible(Class<?>[] target, Class<?>[] canIBeAssignedToTarget);
    boolean moreSpecific(Class<?>[] target, Class<?>[] amIMoreSpecificThanTarget);
}
