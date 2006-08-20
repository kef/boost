package au.net.netstorm.boost.nursery.reflect.checker;

public interface ConstructorNullParameterTestChecker {
    void checkPublicConstructorsRejectNull(Class classToCheck);
}