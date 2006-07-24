package au.net.netstorm.boost.test.checker;

import java.lang.reflect.Method;

public interface MethodNullParameterTestChecker {
    void checkPublicMethodsRejectNull(Class classToCheck);

    void checkMethodRejectsNull(Method method);
}
