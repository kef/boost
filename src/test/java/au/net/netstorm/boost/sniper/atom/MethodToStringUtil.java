package au.net.netstorm.boost.sniper.atom;

import java.lang.reflect.Method;

interface MethodToStringUtil {
    String toString(Method method);

    String toString(String methodName);
}
