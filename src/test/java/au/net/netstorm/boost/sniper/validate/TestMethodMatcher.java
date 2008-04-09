package au.net.netstorm.boost.sniper.validate;

import java.lang.reflect.Method;
import junit.framework.TestCase;

public final class TestMethodMatcher implements MethodMatcher {
    public boolean matches(Method method) {
        if (!TestCase.class.isAssignableFrom(method.getDeclaringClass())) return false;
        if (!method.getReturnType().equals(void.class)) return false;
        if (!(method.getParameterTypes().length == 0)) return false;
        return method.getName().startsWith("test");
    }
}
