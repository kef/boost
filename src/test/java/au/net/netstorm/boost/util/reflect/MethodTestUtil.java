package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

public interface MethodTestUtil {
    Object invoke(Object invokee, String methodName, Object[] parameters);
    // FIXME: SC042 Invoke with a CallSpec.

    Class getThrowsType(Method method);
}
