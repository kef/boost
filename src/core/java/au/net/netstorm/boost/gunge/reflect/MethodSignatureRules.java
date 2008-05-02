package au.net.netstorm.boost.gunge.reflect;


public interface MethodSignatureRules {
    boolean compatible(Class<?>[] target, Class<?>[] canIBeAssignedToTarget);
    boolean moreSpecific(Class<?>[] target, Class<?>[] amIMoreSpecificThanTarget);
}
