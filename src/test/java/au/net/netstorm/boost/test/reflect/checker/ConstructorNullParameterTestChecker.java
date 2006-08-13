package au.net.netstorm.boost.test.reflect.checker;

public interface ConstructorNullParameterTestChecker {
    void checkPublicConstructorsRejectNull(Class classToCheck);
}