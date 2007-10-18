package au.net.netstorm.boost.test.reflect.util;

import java.lang.reflect.Method;

public interface MethodTestUtil {
    Object invoke(Object invokee, String methodName, Object[] parameters);

    Class getThrowsType(Method method);
}
