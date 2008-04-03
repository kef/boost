package au.net.netstorm.boost.gunge.atom;

import java.lang.reflect.Method;

interface MethodToStringUtil {
    String toString(Method method);

    String toString(String methodName);
}
