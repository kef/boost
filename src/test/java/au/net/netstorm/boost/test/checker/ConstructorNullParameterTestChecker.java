package au.net.netstorm.boost.test.checker;

import java.lang.reflect.Constructor;

public interface ConstructorNullParameterTestChecker {
    void checkPublicConstructorsRejectNull(Class classToCheck);

    void checkConstructorRejectsNull(Constructor constructor);
}