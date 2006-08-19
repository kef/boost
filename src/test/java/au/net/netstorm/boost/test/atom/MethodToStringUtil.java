package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Method;

interface MethodToStringUtil {
    String toString(Method method);

    String toString(String methodName);
}
