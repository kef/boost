package au.net.netstorm.boost.test.validate;

import junit.framework.TestCase;

import java.lang.reflect.Method;

public final class TestMethodMatcher implements MethodMatcher {
    public boolean matches(Method method) {
        if (!TestCase.class.isAssignableFrom(method.getDeclaringClass())) return false;
        if (!method.getReturnType().equals(void.class)) return false;
        if (!(method.getParameterTypes().length == 0)) return false;
        return method.getName().startsWith("test");
    }
}
