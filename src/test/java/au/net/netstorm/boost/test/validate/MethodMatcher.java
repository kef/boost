package au.net.netstorm.boost.test.validate;

import java.lang.reflect.Method;

public interface MethodMatcher {
    boolean matches(Method method);
}
