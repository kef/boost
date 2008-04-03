package au.net.netstorm.boost.gunge.validate;

import java.lang.reflect.Method;

public interface MethodMatcher {
    boolean matches(Method method);
}
