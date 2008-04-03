package au.net.netstorm.boost.gunge.atom;

import java.lang.reflect.Method;

final class DefaultMethodToStringUtil implements MethodToStringUtil {
    public String toString(Method method) {
        String methodName = method.getName();
        return toString(methodName);
    }

    public String toString(String methodName) {
        return "Method " + methodName + "()";
    }
}
