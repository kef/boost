package au.net.netstorm.boost.sniper.validate;

import java.lang.reflect.Method;

public interface MethodMatcher {
    boolean matches(Method method);
}
